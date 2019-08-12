package day25_ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpIpServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		List<BufferedWriter> clientList = new ArrayList<BufferedWriter>();
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			Socket socket = null;
			Thread t = null;
			try {
				// System.out.println("Client 요청을 기다립니다.");
				socket = serverSocket.accept();
				t = new ServerThread(socket, clientList);
				t.start();
				System.out.println(socket.getInetAddress() + " 와 연결중입니다.");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}
	}

}

class ServerThread extends Thread {
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	String name;
	List<BufferedWriter> clientList = null;

	public ServerThread() {

	}

	public ServerThread(Socket socket, List<BufferedWriter> clientList) {
		this.socket = socket;
		this.clientList = clientList;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			clientList.add(bw);
			name = br.readLine();
			broadcast(" 님이 입장하셨습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String msg = null;
		try {
			while ((msg = br.readLine()) != null) {
				broadcast(msg);
				if (msg.equalsIgnoreCase("q")) {
					broadcast(" 님 방나감요");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null) {
					clientList.remove(bw);
					bw.close();
				}
				if (socket != null)
					socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private synchronized void broadcast(String msg) {
		clientList.forEach(bw -> {
			try {
				bw.write(name + " : " + msg + "\n");
				bw.flush();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
