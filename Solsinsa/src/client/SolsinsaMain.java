package client;

import java.sql.SQLException;

import gui.Home;

public class SolsinsaMain {

	public static void main(String[] args) throws SQLException {

		Client client = new Client(); // 클라이언트 실행
		client.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 홈 화면
		Home h = new Home();
		h.setVisible(true);

	}

}
