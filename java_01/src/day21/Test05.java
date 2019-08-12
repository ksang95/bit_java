package day21;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UI_5().createUI();
	}

}

class UI_5 extends JFrame implements ActionListener{
	JButton red, blue, exit;
	JTextField msg;
	TextArea output;
	Panel p1,p2;

	void createUI() {
		super.setTitle("awt UI Test~~~");
		p1 = new Panel();
		p1.add(red = new JButton("RED"));
		p1.add(blue = new JButton("BLUE"));
		p1.add(exit = new JButton("종료"));

		add(p1, BorderLayout.SOUTH);
		
		p2=new Panel();
		//p2.setLayout(new GridLayout(1,2));
		p2.add(new JLabel("메세지 창"));
		p2.add(msg=new JTextField(15));
		add(p2,BorderLayout.NORTH);
		add(output=new TextArea(15,40),BorderLayout.CENTER);
		output.setFont(new Font("Serif",Font.PLAIN,24));
		setSize(300, 300);
		setVisible(true);

		red.addActionListener(this);

		blue.addActionListener(this);

		exit.addActionListener(this);

/*		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		msg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				output.append(msg.getText()+"\n");
				msg.setText("");
			}});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ActionEvent 발생");
		System.out.println(e.getActionCommand());
		//if(e.getSource()==red) {
		//	
		//}
		if(e.getActionCommand().equals("RED")) {
			p1.setBackground(Color.RED);
		}
		else if(e.getActionCommand().equals("BLUE")) {
			p1.setBackground(Color.BLUE);
		}
		else {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

}