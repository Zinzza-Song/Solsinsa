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
						addBasket(data);
						writer.println("장바구니담기완료");
						break;
					case 1005:
						// 장바구니 보기
						writer.println(showBasket(data));
						break;
					case 1006:
						// 결제하기
						pay(data);
						writer.println("결제완료");
						break;
					case 1007:
						// 회원 정보 수정
						updateUserInfo(data);
						writer.println("회원정보수정완료");
						break;
					case 1008:
						// 회원 탈퇴
						delUser(data);
						writer.println("회원탈퇴완료");
						break;
					case 1009:
						// 구매목록
						writer.println(showOrders(data));
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
			
			ArrayList<User> users = new ArrayList<>();
			ArrayList<Product> products = new ArrayList<>();
			ArrayList<Top> tops = new ArrayList<>();
			ArrayList<Outer> outers = new ArrayList<>();
			ArrayList<Bottom> bottoms = new ArrayList<>();
			ArrayList<Log> logs = new ArrayList<>();
			
			String pro = "{call all_customer(?)}";
			try(CallableStatement cstmt = con.prepareCall(pro)) {
				cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
				cstmt.execute();
				
				ResultSet rs = (ResultSet)cstmt.getObject(1);
				while(rs.next()) {
					int no = rs.getInt("c_no");
					String id = rs.getString("c_id");
					String pw = rs.getString("c_pw");
					String name = rs.getString("c_name");
					String birth = rs.getString("c_birth");
					String addr = rs.getString("c_addr");
					String phone = rs.getString("c_phone");
					String mail = rs.getString("c_mail");
					
					User user = new User();
					user.setNo(no);
					user.setPw(pw);
					user.setName(name);
					user.setBirth(birth);
					user.setAddr(addr);
					user.setPhone(phone);
					user.setMail(mail);
					
					users.add(user);
				}
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			pro = "{call all_product(?)}";
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
				rs.close();
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
				rs.close();
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
				rs.close();
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
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			pro = "{call selectLog_All(?)}";
			try(CallableStatement cstmt = con.prepareCall(pro)) {
				cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
				cstmt.execute();
				
				ResultSet rs = (ResultSet)cstmt.getObject(1);
				while(rs.next()) {
					String date = rs.getString("l_date");
					String msg = rs.getString("l_msg");
					int code = rs.getInt("l_code");
					
					Log log = new Log();
					log.setDate(date);
					log.setMsg(msg);
					log.setCode(code);
					
					logs.add(log);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			HashMap<Object, Object> map = new HashMap<>();
			map.put("user", users);
			map.put("product", products);
			map.put("top", tops);
			map.put("outer", outers);
			map.put("bottom", bottoms);
			map.put("log", logs);
			
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
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return res + "/" + userData;
	}
	
	void addBasket(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		int c_no = Integer.parseInt(st.nextToken());
		int p_no = Integer.parseInt(st.nextToken());
		
		String pro = "{call addBasket(?,?)}";
		try(CallableStatement cstmt = con.prepareCall(pro)) {
			cstmt.setInt(1, c_no);
			cstmt.setInt(2, p_no);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	String showBasket(String data) {
		int c_no = Integer.parseInt(data);
		
		String res = "";
		String pro = "{call selectBasket(?,?)}";
		try(CallableStatement cstmt = con.prepareCall(pro)) {
			cstmt.setInt(1, c_no);
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			while(rs.next())
				res += rs.getString("p_name") + "," + rs.getString("p_price") + "/";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	void pay(String data) {
		StringTokenizer st = new StringTokenizer(data, "/");
		int c_no = Integer.parseInt(st.nextToken());
		String p_nos = st.nextToken();
		
		st = new StringTokenizer(p_nos, ",");
		while(st.hasMoreTokens()) {
			int p_no = Integer.parseInt(st.nextToken());
			
			String pro = "{call del_basket(?,?)}";
			try(CallableStatement cstmt = con.prepareCall(pro)) {
				cstmt.setInt(1, c_no);
				cstmt.setInt(2, p_no);
				cstmt.execute();
			} catch (SQLException e) {
				System.out.println("del오류");
				e.printStackTrace();
			}
			
			pro = "{call addorders(?,?)}";
			try(CallableStatement cstmt = con.prepareCall(pro)) {
				cstmt.setInt(1, c_no);
				cstmt.setInt(2, c_no);
				cstmt.execute();
			} catch (SQLException e) {
				System.out.println("insert오류");
				e.printStackTrace();
			}
			
			pro = "{call updateProduct(?,?)}";
			try(CallableStatement cstmt = con.prepareCall(pro)) {
				cstmt.setInt(1, p_no);
				cstmt.setInt(2, -1);
				cstmt.execute();
			} catch (SQLException e) {
				System.out.println("update오류");
				e.printStackTrace();
			}
		}
	}
	
	void updateUserInfo(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		String id = st.nextToken();
		String pw = st.nextToken();
		String addr = st.nextToken();
		String phone = st.nextToken();
		String mail = st.nextToken();
		
		String pro = "{call updateCustomer(?,?,?,?,?)}";
		try(CallableStatement cstmt = con.prepareCall(pro)) {
			cstmt.setString(1, id);
			cstmt.setString(2, pw);
			cstmt.setString(3, addr);
			cstmt.setString(4, phone);
			cstmt.setString(5, mail);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void delUser(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		String id = st.nextToken();
		String pw = st.nextToken();
		
		String pro = "{call delCustomer(?,?)}";
		try(CallableStatement cstmt = con.prepareCall(pro)) {
			cstmt.setString(1, id);
			cstmt.setString(2, pw);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	String showOrders(String data) {
		int c_no = Integer.parseInt(data);
		
		String res = "";
		String pro = "{call order_select(?,?)}";
		try(CallableStatement cstmt = con.prepareCall(pro)) {
			cstmt.setInt(1, c_no);
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			while(rs.next()) {
				String name = rs.getString("p_name");
				int price = rs.getInt("p_price");
				String date = rs.getString("o_date");
				res += name + "," + price + "," + date + "/";
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	String adminUIInit() {
		return null;
	}
	
	String showDetailLog(String data) {
		return null;
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
