package day21;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UI_3();
	}

}

class UI_3 extends Frame implements ActionListener{
	Button red, blue, exit;
	Panel p1;

	UI_3() {
		super("awt UI Test~~~");
		p1 = new Panel();
		p1.add(red = new Button("RED"));
		p1.add(blue = new Button("BLUE"));
		p1.add(exit = new Button("종료"));

		add(p1, BorderLayout.SOUTH);
		setSize(300, 300);
		setVisible(true);

		red.addActionListener(this);

		blue.addActionListener(this);

		exit.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
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