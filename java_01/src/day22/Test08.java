package day22;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		Properties prop = new Properties();
		String src = "c:\\lib\\dbinfo.txt";
		try {
			fr = new FileReader(src);
			prop.load(fr);
			String id = prop.getProperty("user");
			String pw = prop.getProperty("pw");

			System.out.println("로그인 시도");
			System.out.println("ID: " + id + ", PW: " + pw);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(src + " 파일(복사원본) 준비해주세요.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("  main end  ");
	}

}
