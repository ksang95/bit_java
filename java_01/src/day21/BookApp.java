package day21;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BookApp extends JFrame {
	static int num = 0;
	BookMgr mgr = new BookMgr();
	JPanel panel1, panel2;
	JButton insert, delete, listP, search, newList, save, saveAs, load, quit;
	JLabel label1;
	TextArea text;
	List<Book> bookList = new ArrayList<Book>();
	String loading;

	BookApp() {
		super("BookApp");
		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel("명령 선택");
		insert = new JButton("INSERT");
		delete = new JButton("DELETE");
		listP = new JButton("LIST");
		search = new JButton("SEARCH");
		quit = new JButton("QUIT");
		newList = new JButton("NEW");
		save = new JButton("SAVE");
		saveAs = new JButton("SAVE AS");
		load = new JButton("LOAD");
		text = new TextArea();
		text.setEditable(false);
		text.setFont(new Font(null, Font.PLAIN, 20));
		panel1.add(label1);
		panel1.add(insert);
		panel1.add(delete);
		panel1.add(listP);
		panel1.add(search);
		panel2.add(newList);
		panel2.add(save);
		panel2.add(saveAs);
		panel2.add(load);
		panel2.add(quit);
		insert.addActionListener(new MiniAction());
		delete.addActionListener(new MiniAction());
		listP.addActionListener(new MiniAction());
		search.addActionListener(new MiniAction());
		quit.addActionListener(new MiniAction());
		newList.addActionListener(new MiniAction());
		save.addActionListener(new MiniAction());
		saveAs.addActionListener(new MiniAction());
		load.addActionListener(new MiniAction());
		add(panel1, BorderLayout.NORTH);
		add(text, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class MiniAction implements ActionListener {
		public void print(List<Book> list) {
			text.setText("");
			list.forEach(i -> text.append(i.toString() + "\n"));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch (e.getActionCommand()) {
			case "INSERT":
				String title = JOptionPane.showInputDialog("Book Title 입력");
				String respond = JOptionPane.showInputDialog("Book Price 입력");
				int price;
				boolean flag;
				if (title != null && respond != null) {
					try {
						price = Integer.parseInt(respond);
						flag = mgr.addBook(new Book(++num, title, price));
						if (!flag)
							JOptionPane.showMessageDialog(null, "등록에 실패하였습니다.");
						else {
							print(mgr.bookListPrint());
							JOptionPane.showMessageDialog(null, "Book[" + title + ":" + price + "]를 등록하였습니다.");
						}
					} catch (Exception e1) {
						text.setText("잘못된 입력입니다.");
						text.append("price는 숫자만 입력하세요.");
					}
				}
				break;
			case "DELETE":
				title = JOptionPane.showInputDialog("삭제할 Book Title 입력");
				if (title != null) {
					flag = mgr.deleteBook(title);
					if (!flag)
						JOptionPane.showMessageDialog(null, title + " 제목의 책이 존재하지 않습니다.");
					else {
						print(mgr.bookListPrint());
						JOptionPane.showMessageDialog(null, "삭제되었습니다.");
					}
				}
				break;
			case "LIST":
				bookList = mgr.bookListPrint();
				Collections.sort(bookList);
				print(bookList);
				break;
			case "SEARCH":
				title = JOptionPane.showInputDialog("검색할 title 입력");
				if (title != null) {
					bookList = mgr.searchBook(title);
					Collections.sort(bookList);
					print(bookList);
				}
				break;
			case "NEW":
				mgr.setList(new ArrayList<Book>());
				num = 0;
				loading=null;
				text.setText("");
				break;
			case "SAVE":
				if (loading != null) {
					if (mgr.saveBook(loading))
						JOptionPane.showMessageDialog(null, "저장되었습니다.");
					else
						JOptionPane.showMessageDialog(null, "저장에 실패하였습니다.");
					break;
				}
			case "SAVE AS":
				String name;
				name = JOptionPane.showInputDialog("저장할 파일 이름 입력");
				if (name != null) {
					if (mgr.saveBook(name)) {
						JOptionPane.showMessageDialog(null, "저장되었습니다.");
						loading = name;
					} else
						JOptionPane.showMessageDialog(null, "저장에 실패하였습니다.");
				}
				break;
			case "LOAD":
				name = JOptionPane.showInputDialog("불러올 파일 이름 입력");
				if (name != null) {
					if (mgr.loadBook(name)) {
						bookList = mgr.bookListPrint();
						Collections.sort(bookList);
						print(bookList);
						num = mgr.maxIsbn();
						loading = name;
					} else
						JOptionPane.showMessageDialog(null, "파일을 불러올 수 없습니다.");
				}
				break;
			case "QUIT":
				int exit = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?");
				if (exit == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
				break;
			default:
				break;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new BookApp();
	}

}
