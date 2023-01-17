package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnector {

	public static Connection getCon() {

		Connection con = null;

		try {
			String id = "your id"; // 계정명
			String pw = "your password"; // 계정패스워드
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 호스트 위치

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class 클래스로 JDBC 드라이버를 로딩하는 코드 => DriverManager에 등록됨

			con = DriverManager.getConnection(url, id, pw);
			// Connection 객체를 얻음
			// con은 실제로 데이터베이스와 연결하여 작업을 수행할 수 있는 통로로 자용하는 중요한 객체 변수로 사용

			return con;
		} catch (Exception e) { // db위치에서 작업할 경우(호스트에서는 호스트의 외부아이피로 접근 불가)
			System.out.println("DB연결 실패");
			return null;
		}

	}

}
