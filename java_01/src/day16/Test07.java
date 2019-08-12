package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = null;
		try {
			s = new Scanner(new File("c://lib//sample.txt"));
			while(s.hasNextLine()) {
				String[] data=s.nextLine().replace('_','/').split("/");
				System.out.println(Arrays.toString(data));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
				s = null;
			}
		}
		System.out.println("main end");
	}

}
