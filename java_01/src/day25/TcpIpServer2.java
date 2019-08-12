package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TcpIpServer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		List<BufferedWriter> list = new ArrayList<BufferedWriter>();

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
				t = new ChattingThread2(socket, list);
				t.start();
				System.out.println(socket.getInetAddress() + " 와 연결중입니다.");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}
	}

}

class ChattingThread2 extends Thread {
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	String name;
	List<BufferedWriter> list;
	String line = null;

	public ChattingThread2() {

	}

	public ChattingThread2(Socket socket, List<BufferedWriter> list) {
		this.socket = socket;
		this.list = list;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			list.add(bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			name = br.readLine();
			System.out.println(name + "님 안녕하세요\n");
			line = name + "님 안녕하세요\n";
			writeMsg(line);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void writeMsg(String line) throws Exception {
		Iterator<BufferedWriter> it = list.iterator();
		while (it.hasNext()) {
			BufferedWriter data = it.next();
			data.write(line);
			data.flush();
		}
	}

	@Override
	public void run() {
		try {
			while ((line = br.readLine()) != null) {
				writeMsg(name + " : " + line + "\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null) {
					list.remove(bw);
					bw.close();
				}
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
