package App;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.BookDAO;
import dao.BookDAO_Oracle;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Gui();
		
	}

}

class Gui extends JFrame {
	JButton add, list, delete, search, exit;
	JTextField title, price, isbn,publisher;
	TextArea output;
	BookDAO dao=new BookDAO_Oracle();
	BookService service=new BookServiceImpl(dao);

	Gui() {

		Panel p1 = new Panel();
		p1.add(add = new JButton("ADD"));
		p1.add(list = new JButton("LIST"));
		p1.add(delete = new JButton("DELETE"));
		p1.add(search = new JButton("SEARCH"));
		p1.add(exit = new JButton("EXIT"));
		add(p1, BorderLayout.SOUTH);

		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(4, 2));
		p2.add(new JLabel("  ISBN   "));
		p2.add(isbn = new JTextField(20));
		p2.add(new JLabel("  제      목    "));
		p2.add(title = new JTextField(20));
		p2.add(new JLabel("  가      격    "));
		p2.add(price = new JTextField(20));
		p2.add(new JLabel("  출 판 사     "));
		p2.add(publisher = new JTextField(20));
		add(p2, BorderLayout.NORTH);

		add(output = new TextArea(15, 40));
		output.setFont(new Font(null, 1, 20));

		pack();
		setVisible(true);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add.addActionListener(e -> {
			BookVO vo=new BookVO();
			vo.setBookid(Integer.parseInt(isbn.getText()));
			vo.setBookname(title.getText());
			vo.setPrice(Integer.parseInt(price.getText()));
			vo.setPublisher(publisher.getText());
			service.addBook(vo);
			isbn.setText("");
			title.setText("");
			price.setText("");
			publisher.setText("");
		});

		exit.addActionListener(e -> {
			
			System.exit(0);
		});

		list.addActionListener(e -> {
			output.setText(" BookList  \n");
			service.bookList().forEach(i->output.append(i+"\n"));
		});

		delete.addActionListener(e -> {
			int i=service.deleteBook(Integer.parseInt(isbn.getText()));
			output.setText(i+"개의 도서 삭제  \n");
			isbn.setText("");
			title.setText("");
			price.setText("");
			publisher.setText("");
		});

		search.addActionListener(e -> {
			output.setText(" 검색 결과  \n");
			
		});

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				System.exit(0);
			}

		});
	}
}