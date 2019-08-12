package day23_ex;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Collections;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BookApp {

	public static void main(String[] args) {
		new Gui();
	}
}

class Gui extends JFrame {
	// static int num = 0;
	BookMgr mgr;
	JButton add, list, delete, search, exit;
	TextField title, price, isbn;
	TextArea output;

	Gui() {
		mgr = new BookMgr();

		Panel p1 = new Panel();
		p1.add(add = new JButton("ADD"));
		p1.add(list = new JButton("LIST"));
		p1.add(delete = new JButton("DELETE"));
		p1.add(search = new JButton("SEARCH"));
		p1.add(exit = new JButton("EXIT"));
		add(p1, BorderLayout.SOUTH);

		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(3, 2));
		p2.add(new JLabel("  제      목   "));
		p2.add(title = new TextField(20));
		p2.add(new JLabel("  가      격  "));
		p2.add(price = new TextField(20));
		add(p2, BorderLayout.NORTH);

		add(output = new TextArea(15, 40));
		output.setFont(new Font(null, 1, 20));

		pack();
		setVisible(true);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add.addActionListener(e -> {
			int p = 0;
			try {
				p = Integer.parseInt(price.getText());
				Book book = new Book(title.getText(), p);
				if (mgr.add(book))
					output.setText(book + " 가 등록되었습니다.");
				else
					output.setText("등록이 실패하였습니다.\n중복되는 제목의 책이 있습니다.");
			} catch (NumberFormatException e1) {
				output.setText("가격은 숫자만 입력하세요.");
			}
		});

		exit.addActionListener(e -> {
			mgr.save();
			System.exit(0);
		});

		list.addActionListener(e -> {
			output.setText(" BookList  \n");
			mgr.getBookList().forEach(i -> {
				output.append(i + "\n");
			});
		});

		delete.addActionListener(e -> {
			boolean flag = mgr.delete(title.getText());
			if (!flag)
				output.setText(title.getText() + " 이 존재하지 않습니다.");
			else {
				output.setText(title.getText() + " 가 삭제되었습니다.");
			}

		});

		search.addActionListener(e -> {
			output.setText(" 검색 결과  \n");
			mgr.search(title.getText()).forEach(i -> {
				output.append(i + "\n");
			});
		});

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				mgr.save();
				setVisible(false);
				dispose();
				System.exit(0);
			}

		});
	}
}