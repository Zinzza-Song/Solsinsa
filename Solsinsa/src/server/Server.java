package server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {

	private static Socket client;
	static PrintWriter out = null;
	static ArrayList<Socket> list = new ArrayList<Socket>();
	static int UserNum = 0;
	
	public Server(Socket client) {
		this.client = client;
		list.add(client);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {

	}

}
