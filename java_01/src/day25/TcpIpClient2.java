package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpClient2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String serverIp = "127.0.0.1";
		// String serverIp = "192.168.0.135";
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		Scanner s = new Scanner(System.in);
		String line = null;
		String id = null;
		Thread t = null;
		try {
			System.out.println(serverIp + " 연결 시도할게요..");
			socket = new Socket(serverIp, 7777);
			System.out.println("서버와 연결이 되었습니다.");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			t = new ReadingThread2(br);
			System.out.println("id를 입력하세요.");
			id = s.nextLine();
			bw.write(id + "\n");
			bw.flush();
			//System.out.println(br.readLine());
			System.out.println("메시지 입력하세요. 끝내려면 q/Q 입력.");
			t.start();
			while (true) {
				line = s.nextLine();
				bw.write(line + "\n");
				bw.flush();
				//System.out.println(br.readLine());
				if (line.equalsIgnoreCase("q")) {
					break;
				}
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
				if (s != null)
					s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

class ReadingThread2 extends Thread {
	BufferedReader br;

	ReadingThread2() {
	}

	ReadingThread2(BufferedReader br) {
		this.br = br;
	}

	@Override
	public void run() {
		String line;
		try {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
	}
}