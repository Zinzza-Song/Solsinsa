package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnector {
	
public static Connection getCon() throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		
		try {
			String id = "c##zinzza"; // ������
			String pw = "1234"; // �����н�����
			String url = "jdbc:oracle:thin:@1.239.126.62:11521:xe"; // ȣ��Ʈ ��ġ
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class Ŭ������ JDBC ����̹��� �ε��ϴ� �ڵ� => DriverManager�� ��ϵ�
			
			con = DriverManager.getConnection(url, id, pw);
			// Connection ��ü�� ����
			// con�� ������ �����ͺ��̽��� �����Ͽ� �۾��� ������ �� �ִ� ��η� �ڿ��ϴ� �߿��� ��ü ������ ���
			
			return con;
		} catch (Exception e) { // db��ġ���� �۾��� ���(ȣ��Ʈ������ ȣ��Ʈ�� �ܺξ����Ƿ� ���� �Ұ�)
			String id = "c##zinzza"; // ������
			String pw = "1234"; // �����н�����
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // db��ġ
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class Ŭ������ JDBC ����̹��� �ε��ϴ� �ڵ� => DriverManager�� ��ϵ�
			
			con = DriverManager.getConnection(url, id, pw);
			// Connection ��ü�� ����
			// con�� ������ �����ͺ��̽��� �����Ͽ� �۾��� ������ �� �ִ� ��η� �ڿ��ϴ� �߿��� ��ü ������ ���
			
			return con;
		}
		
	}

}
