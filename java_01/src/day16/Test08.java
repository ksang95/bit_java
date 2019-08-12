package day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (FileInputStream fis = new FileInputStream("c://lib//sample.txt");) {
			System.out.println("파일 정리");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		try (Scanner s = new Scanner(new File("c://lib//sample.txt"));) {
			while (s.hasNextLine()) {
				String[] data = s.nextLine().replace('_', '/').split("/");
				System.out.println(Arrays.toString(data));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
