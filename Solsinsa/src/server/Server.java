package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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

			while (true) {
				String msg = br.readLine();
				System.out.println("요청 : " + msg);

				st = new StringTokenizer(msg, ":");

				String data = st.nextToken();
				int protocol = Integer.parseInt(st.nextToken());

				if (protocol == 9999)
					break;
				else {
					switch (protocol) {
					case 1000:
						// 상품 불러오기
						// 클라이언트가 최초 실행시 product 테이블의 모든 데이터를 불러와서 클라이언트로 쏴준다.
						// p_bottom, p_outer, p_top의 모든 데이터도 같이 쏴준다.
						// 프로시저 all_product, selectProduct_bottom, selectProduct_outer,
						// selectProduct_top 사용
						appStart();
						break;
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
					case 1004:
						// 장바구니 담기
						// 클라이언트가 상품담기를 클릭시 유저코드와 해당 상품 코드를 basket테이블에 추가
						// 프로시저 addBasket 사용
						break;
					case 1005:
						// 장바구니 보기
						// 클라이언트가 장바구니 보기를 클릭하면 유저코드를 db로 보내 해당 데이터가 담긴 커서를 뽑아서 클라이언트로 쏴준다.
						// 프로시저 selectBasket 사용
						break;
					case 1006:
						// 결제하기
						// 클라이언트가 결제하기를 누르면 유저코드와 해당 상품코드를 db로 보내 basket 테이블에서 해당 컬럼을 삭제
						// 위에서 삭제 후 orders 테이블에 해당 유저코드와 상품코드와 구매날짜를 보내 인서트
						// 위 작업 후 product 테이블에서 재고량을 -1을 해주는 업데이트 작업
						// 프로시저 del_basket, (orders 테이블 인서트 프로시저 아직 없음), updateProduct 사용
						break;
					case 1007:
						// 회원 정보 수정
						// 클라이언트가 회원정보 수정 버튼을 클릭시 입력한 값으로 customer 테이블을 업데이트(바꾸든 안 바꾸든 일단 덮어쓰는 방식)
						// 프로시저 updateCustomer 사용
						break;
					case 1008:
						// 회원 탈퇴
						// 회원 탈퇴를 할 경우 해당 유저의 아이디와 비밀번호를 db로 보내 해당 컬럼을 삭제
						// 프로시저 delCustomer 사용
						break;
					case 1009:
						// 구매목록
						// 마이페이지 들어갔을 때 하단에 구매목록을 띄어야한다
						// 구매한 상품 이름, 가격, 구매 날짜가 뜨는 값이 담긴 커서를 뽑도록 요청
						// 프로시저 order_select 사용
						break;
					case 1010:
						// 관리자 초기 화면 세팅
						// 관리자가 로그인해서 Lookup 객체가 생성되면 실행
						// 물품정보와 회원정보 전체로그를 불러와서 세팅
						// 프로시저 selectLog_All, all_customer, all_product
						break;
					case 1011:
						// 구분 로그
						// 상품로그보기 버튼 혹은 회원로그보기 버튼을 누르면 해당 코드를 보내 해당 로그만 보여준다.
						// 프로시저 selectLog_choice사용
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

	void appStart() { // 클라이언트가 실행되면 db에 있는 상품테이블의 데이터와 상의 하의 아우터 상세정보 테이블의 데이터들을 
		try {
			ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
			
			ArrayList<Product> products = new ArrayList<>();
			ArrayList<Top> tops = new ArrayList<>();
			ArrayList<Outer> outers = new ArrayList<>();
			ArrayList<Bottom> bottoms = new ArrayList<>();
			
			String pro = "{call all_product(?)}";
			
			try(CallableStatement cstmt = con.prepareCall(pro)){
				cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
				cstmt.execute();
				
				ResultSet rs = (ResultSet) cstmt.getObject(1);
				while(rs.next()) {
					int no = rs.getInt("p_no");
					String name = rs.getString("p_name");
					int price = rs.getInt("p_price");
					int category_code = rs.getInt("p_ctg");
					int stock = rs.getInt("p_stock");
					String img = rs.getString("p_img");
					
					Product product = new Product();
					product.setNo(no);
					product.setName(name);
					product.setPrice(price);
					if(category_code == 1)
						product.setCategory("상의");
					else if(category_code == 2)
						product.setCategory("하의");
					else if(category_code == 3)
						product.setCategory("아우터");
					product.setStock(stock);
					product.setImg(img);
					
					products.add(product);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			pro = "{call selectProduct_top(?)}";
			try(CallableStatement cstmt = con.prepareCall(pro)){
				cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
				cstmt.execute();
				
				ResultSet rs = (ResultSet) cstmt.getObject(1);
				while(rs.next()) {
					String img = rs.getString("p_img_top");
					String material = rs.getString("p_material");
					String fit = rs.getString("p_fit");
					String touch = rs.getString("p_touch");
					String flexible = rs.getString("p_flexible");
					String through = rs.getString("p_through");
					String thickness = rs.getString("p_thickness");
					String size = rs.getString("p_size");
					int length = rs.getInt("p_length");
					int shoulder = rs.getInt("p_shoulder");
					int chest = rs.getInt("p_chest");
					int sleeve = rs.getInt("p_sleeve");
					
					Top top = new Top();
					top.setImg(img);
					top.setMaterial(material);
					top.setFit(fit);
					top.setTouch(touch);
					top.setFlexible(flexible);
					top.setThrough(through);
					top.setThickness(thickness);
					top.setSize(size);
					top.setLength(length);
					top.setShoulder(shoulder);
					top.setChest(chest);
					top.setSleeve(sleeve);
					
					tops.add(top);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			pro = "{call selectProduct_outer(?)}";
			try(CallableStatement cstmt = con.prepareCall(pro)){
				cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
				cstmt.execute();
				
				ResultSet rs = (ResultSet) cstmt.getObject(1);
				while(rs.next()) {
					String img = rs.getString("p_img_outer");
					String material = rs.getString("p_material");
					String fit = rs.getString("p_fit");
					String touch = rs.getString("p_touch");
					String flexible = rs.getString("p_flexible");
					String through = rs.getString("p_through");
					String thickness = rs.getString("p_thickness");
					String size = rs.getString("p_size");
					int length = rs.getInt("p_length");
					int shoulder = rs.getInt("p_shoulder");
					int chest = rs.getInt("p_chest");
					int sleeve = rs.getInt("p_sleeve");
					
					Outer outer = new Outer();
					outer.setImg(img);
					outer.setMaterial(material);
					outer.setFit(fit);
					outer.setTouch(touch);
					outer.setFlexible(flexible);
					outer.setThrough(through);
					outer.setThickness(thickness);
					outer.setSize(size);
					outer.setLength(length);
					outer.setShoulder(shoulder);
					outer.setChest(chest);
					outer.setSleeve(sleeve);
					
					outers.add(outer);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			pro = "{call selectProduct_bottom(?)}";
			try(CallableStatement cstmt = con.prepareCall(pro)){
				cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
				cstmt.execute();
				
				ResultSet rs = (ResultSet) cstmt.getObject(1);
				while(rs.next()) {
					String img = rs.getString("p_img_bottom");
					String material = rs.getString("p_material");
					String fit = rs.getString("p_fit");
					String touch = rs.getString("p_touch");
					String flexible = rs.getString("p_flexible");
					String through = rs.getString("p_through");
					String thickness = rs.getString("p_thickness");
					String size = rs.getString("p_size");
					int length = rs.getInt("p_length");
					int waist = rs.getInt("p_waist");
					int thigh = rs.getInt("p_thigh");
					int rise = rs.getInt("p_rise");
					int hem = rs.getInt("p_hem");
					
					Bottom bottom = new Bottom();
					bottom.setImg(img);
					bottom.setMaterial(material);
					bottom.setFit(fit);
					bottom.setTouch(touch);
					bottom.setFlexible(flexible);
					bottom.setThrough(through);
					bottom.setThickness(thickness);
					bottom.setSize(size);
					bottom.setLength(length);
					bottom.setWaist(waist);
					bottom.setThigh(thigh);
					bottom.setRise(rise);
					bottom.setHem(hem);
					
					bottoms.add(bottom);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			HashMap<Object, Object> map = new HashMap<>();
			map.put("product", products);
			map.put("top", tops);
			map.put("outer", outers);
			map.put("bottom", bottoms);
			
			oos.writeObject(map);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void insertUser(String data) { // 회원가입 메소드
		StringTokenizer st = new StringTokenizer(data, ","); // 회원가입을 위한 각각의 데이터를 분류

		String pro = "{call addCustomer(?, ?, ?, ?, ?, ?, ?)}"; // 회원가입을 위한 프로시저 콜

		try (CallableStatement cstmt = con.prepareCall(pro)) {

			int i = 1; // 회원가입을 위한 데이터들을 세팅
			while (st.hasMoreTokens()) {
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

		try (CallableStatement cstmt = con.prepareCall(pro)) {
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
		try (CallableStatement cstmt = con.prepareCall(pro)) {
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
		try (CallableStatement cstmt = con.prepareCall(pro)) {
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.execute();

			ResultSet rs = (ResultSet) cstmt.getObject(2);
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

		try (ServerSocket server = new ServerSocket(7048)) { // try-with-resource문을 사용하여 다 사용하고나서 자동으로 자원 해제
			while (true) { // 서버를 종료하지 않는한 무한 서비스 제공
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
