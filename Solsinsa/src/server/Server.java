package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jdbc.JdbcConnector;

public class Server implements Runnable {

	private static Socket client; // 클라이언트 구분을 위한 소켓 변수
//	static PrintWriter out = null;
	static ArrayList<Socket> list = new ArrayList<Socket>(); // 클라이언트 쓰레드를 담을 리스트
	static int UserNum = 0;
	
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
			
			UserNum++;
			System.out.println("클라이언트" + UserNum + "(" + Thread.currentThread() + ")" + "연결됨");
			
//			String userId = br.readLine(); // 클라이언트에게 id를 입력 받아 설정
//			String inputLine; // 클라이언트가 보낸 값 저장
			
//			writer.println(userId + "님이 접속");
//			System.out.println(userId + "님이 접속");
//			(inputLine = br.readLine()) != null
			
			StringTokenizer st = null;
			
			while(true) {
//				writer.println(userId + " : " + inputLine); // 메시지 송신
				String msg = br.readLine();
				
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
					default:
						break;
					}
				}
			}
			
			out.close();
			System.out.println("클라이언트" + Thread.currentThread() + "종료");
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("클라 비정상 종료");
			list.remove(client);
		}
		
	}
	
	void insertUser(String data) {
		
		String pro = "{call addCustomer(?, ?, ?, ?, ?, ?, ?)}";
	
		try (PreparedStatement pstmt = con.prepareStatement(pro)){
			StringTokenizer st = new StringTokenizer(data, ",");
			int i = 1;
			while(st.hasMoreTokens()) {
				pstmt.setString(i, st.nextToken());
				i++;
			}
			
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
