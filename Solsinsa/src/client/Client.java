package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import server.Bottom;
import server.Outer;
import server.Product;
import server.Top;

public class Client extends Thread {

	Socket socket;
	BufferedReader br;
	PrintWriter out;
	Scanner sc;

	public static String msg = null;
	public static String ans = null;
	
	public static ArrayList<Product> products;
	public static ArrayList<Top> tops;
	public static ArrayList<Outer> outers;
	public static ArrayList<Bottom> bottoms;

	final String localhost = "127.0.0.1";

	@Override
	public void run() {
		System.out.println("Connecting...");

		try {
			// 서버의 accept()가 호출 후 쓰레드가 만들어지고, List에 추가됨
			socket = new Socket(localhost, 7048); // 7048포트로 서버와 연결

			out = new PrintWriter(socket.getOutputStream(), true);

			System.out.println("Connected!!");
			out.println("start:1000");
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			HashMap<Object, Object> map = (HashMap<Object, Object>) ois.readObject();
			products = (ArrayList<Product>) map.get("product");
			tops = (ArrayList<Top>)map.get("top");
			outers = (ArrayList<Outer>)map.get("outer");
			bottoms = (ArrayList<Bottom>)map.get("bottom");

			SocketThread thread = new SocketThread(); // 메시지 수신을 위한 쓰레드 객체 생성
			thread.start(); // 생성한 쓰레드 객체 실행

			while (true) {
				sleep(1000);
				if (msg != null) {
					System.out.println("요청할 메시지 : " + msg);
					out.println(msg); // 입력받은 키보드 값을 서버로 전송

					if (msg.equals("end"))
						break;

					msg = null;
				}
			}
			System.out.println("클라종료");
			socket.close();
			thread.interrupt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class SocketThread extends Thread { // 메시지 수신

		@Override
		public void run() {
			try {
				while (!this.isInterrupted()) {
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String res = null; // 수신된 메시지를 저장
					while ((res = br.readLine()) != null) { // br에 읽을 메시지가 있는 한 무한루프
						ans = res;
						System.out.println("응답" + ans);
					}
				}
				System.out.println("쓰레드 수정");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
