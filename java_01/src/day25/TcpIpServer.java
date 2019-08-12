package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;

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
				t = new ChattingThread(socket);
				t.start();
				System.out.println(socket.getInetAddress() + " 와 연결중입니다.");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		}
	}

}

class ChattingThread extends Thread {
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	String name;

	public ChattingThread() {

	}

	public ChattingThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		String line = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			name = br.readLine();
			System.out.println(name + "님 안녕하세요\n");
			line = name + "님 안녕하세요\n";
			bw.write(line);
			bw.flush();
			while ((line = br.readLine()) != null) {
				bw.write(name + " : " + line + "\n");
				bw.flush();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
