package day26;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TcpIpClient {
	String id;
	String serverIp = "127.0.0.1";
	Socket socket = null;
	String line = null;
	BufferedReader br = null;
	BufferedWriter bw = null;

	TcpIpClient() {

	}

	TcpIpClient(String id, String serverIp) {
		this.id = id;
		this.serverIp = serverIp;
		System.out.println(serverIp + " 연결 시도할게요..");
		try {
			socket = new Socket(serverIp, 7777);
			System.out.println("서버와 연결이 되었습니다.");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(id + "\n");
			bw.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class ClientThread extends Thread {
	BufferedReader br;
	TextArea text;

	ClientThread() {

	}

	ClientThread(BufferedReader br, TextArea text) {
		this.br = br;
		this.text = text;
	}

	@Override
	public void run() {
		String msg = null;
		try {
			while ((msg = br.readLine()) != null)
				text.append(msg + "\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null) 
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}

}
