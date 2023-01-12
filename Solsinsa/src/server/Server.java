package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jdbc.JdbcConnector;

public class Server implements Runnable {

	private static Socket client; // 클라이언트 구분을 위한 소켓 변수
	static ArrayList<Socket> list = new ArrayList<Socket>(); // 클라이언트 쓰레드를 담을 리스트
	
	static Connection con;
	
	public Server(Socket client) { // 멀티 쓰레드 환경구출을 위한 생성자, 클라이언트별 쓰레드 생성
		this.client = client;
		list.add(client); // 쓰레드를 리스트에 추가
	}
	
	@Override
	public void run() { 
		// 클라이언트 별로 동작하는 메소드
		// 클라이언트 별 송수신관련 메소드와 변수들을 갖고 있음
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream())); // 수신 버퍼
			OutputStream out = client.getOutputStream(); // 클라이언트로 메세지 보내기
			PrintWriter writer = new PrintWriter(out, true); // 송신 버퍼
			
			StringTokenizer st = null;
			
			while(true) {
				String msg = br.readLine();
				System.out.println("요청 : " +  msg);
				
				st = new StringTokenizer(msg, ":");
				
				String data = st.nextToken();
				int protocol = Integer.parseInt(st.nextToken());
				
				if(protocol == 9999)
					break;
				else {
					switch (protocol){
					case 1001: 
						insertUser(data);
						writer.println("회원가입완료");
						break;
					case 1002:
						writer.println(checkId(data));
						break;
					case 1003:
						writer.println(login(data));
						break;
					default:
						break;
					}
				}
			}
			
			out.close();
			System.out.println("클라이언트" + Thread.currentThread() + "종료");
			
		} catch (IOException e) {
			System.out.println("클라 비정상 종료");
			list.remove(client);
		}
		
	}
	
	void insertUser(String data) { // 회원가입 메소드
		StringTokenizer st = new StringTokenizer(data, ","); // 회원가입을 위한 각각의 데이터를 분류
		
		String pro = "{call addCustomer(?, ?, ?, ?, ?, ?, ?)}"; // 회원가입을 위한 프로시저 콜
	
		try (CallableStatement cstmt = con.prepareCall(pro)){
			
			int i = 1; // 회원가입을 위한 데이터들을 세팅
			while(st.hasMoreTokens()) {
				cstmt.setString(i, st.nextToken());
				i++;
			}
			
			cstmt.execute(); // 쿼리문을 날린다
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	int checkId(String data) { // 회원 가입시 아이디 중복 검사 메소드
		String pro = "{call check_id(?,?)}"; 
		// 아이디 중복 검사 프로시저 콜
		// 아이디 사용 가능 : 0을 반환
		// 아이디 중복 : -1을 반환
		
		try (CallableStatement cstmt = con.prepareCall(pro)){
			cstmt.setString(1, data); // 중복 검사를 위한 아이디값 삽입
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.NUMBER); // 결과값 반환을 위한 세팅
			cstmt.execute(); // 쿼리문을 날린다
			
			return cstmt.getInt(2); // 최종적으로 결과값을 반환
		} catch (SQLException e) {
			e.printStackTrace();
			return -2; // 오류가 반환하면 -2를 반환
		}
	}
	
	String login(String data) { // 로그인 메소드
		StringTokenizer st = new StringTokenizer(data, ",");
		String pro = "{call login(?,?,?)}";
		String id = st.nextToken();
		String pw = st.nextToken();
		int res;
		try(CallableStatement cstmt = con.prepareCall(pro)) {
			cstmt.setString(1, id);
			cstmt.setString(2, pw);
			cstmt.registerOutParameter(3, oracle.jdbc.OracleTypes.NUMBER);
			cstmt.execute();
			
			res = cstmt.getInt(3);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		pro = "{call selectLoginCustomer(?, ?)}";
		String userData = "";
		try(CallableStatement cstmt = con.prepareCall(pro)) {
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			while (rs.next()) {
				userData = rs.getString("c_no") + "," + rs.getString("c_id") + "," + rs.getString("c_pw") + ","
						+ rs.getString("c_name") + "," + rs.getString("c_birth") + "," + rs.getString("c_addr") + ","
						+ rs.getString("c_phone") + "," + rs.getString("c_mail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return res + "/" + userData;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		con = JdbcConnector.getCon();
		
		ExecutorService eService = Executors.newFixedThreadPool(100);
		// 쓰레드 생성, 접속자 100명 이하로 제한(원할한 서비스 제공을 위하여 설정)
		
		System.out.println("Server Start");
		
		try(ServerSocket server = new ServerSocket(7048)) { //try-with-resource문을 사용하여 다 사용하고나서 자동으로 자원 해제
			while(true){ // 서버를 종료하지 않는한 무한 서비스 제공
				System.out.println("waiting client....");
				
				client = server.accept(); // 클라이언트 연결 수락
				System.out.println("client connect accpted");
				
				Server tcpServer = new Server(client); // 클라이언트별 쓰레드 객체 생성
				eService.submit(tcpServer); // 생성한 쓰레드 객체를 등록
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Server End");
		eService.shutdown(); // 서버 종료
		
	}

}
