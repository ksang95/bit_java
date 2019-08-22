package day26;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chatting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChattingUI();
	}

}

class ChattingUI extends JFrame {
	JPanel panel;
	JLabel id, serverIp;
	JTextField tid, tserverIp, input;
	JButton enter, exit;
	TextArea text;
	TcpIpClient client;
	Socket socket = null;
	BufferedReader br = null;
	BufferedWriter bw = null;

	ChattingUI() {
		super("채팅 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.add(id = new JLabel("ID"));
		panel.add(tid = new JTextField(15));
		panel.add(serverIp = new JLabel("SERVER IP"));
		panel.add(tserverIp = new JTextField(20));
		panel.add(enter = new JButton("ENTER"));
		panel.add(exit = new JButton("EXIT"));
		add(panel, BorderLayout.NORTH);
		text = new TextArea();
		input = new JTextField();
		add(text, BorderLayout.CENTER);
		add(input, BorderLayout.SOUTH);

		pack();
		setVisible(true);
		setSize(800, 500);

		enter.addActionListener(e -> {
			client = new TcpIpClient(tid.getText(), tserverIp.getText());
			new ClientThread(client.br, text).start();
		});
		exit.addActionListener(e -> {
			try {
				//if (client.br != null)
				//	client.br.close();
				if (client.bw != null) {
					client.bw.write("q\n");
					client.bw.close();
				}
				if (client.socket != null)
					client.socket.close();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			} finally {
			}
		});
		input.addActionListener(e -> {
			try {
				client.bw.write(input.getText() + "\n");
				client.bw.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			input.setText("");
		});
	}

}