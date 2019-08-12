package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = null;
		try {
			s = new Scanner(new File("c://lib//sample.txt"));
			while (s.hasNextLine()) {
				String[] data = s.nextLine().replace('_', '/').split("/");
				// System.out.println(Arrays.toString(data));
				Book book =null;
				try {
					book = new Book(data[0], Integer.parseInt(data[1]));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println(book);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (s != null) {
				s.close();
				s = null;
			}
		}
	}

}
