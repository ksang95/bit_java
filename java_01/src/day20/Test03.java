package day20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties p = new Properties();

		try {
			p.load(new FileInputStream("c:\\lib\\dbinfo.txt"));
			String url=p.getProperty("url");
			System.out.println(url);
			String driver=p.getProperty("driver");
			System.out.println(driver);
			String user=p.getProperty("user");
			System.out.println(user);
			String pw=p.getProperty("pw");
			System.out.println(pw);
			p.setProperty("jdkver", "1.8");
			p.setProperty("oraclever", "11g");
			p.setProperty("tomcatver", "9");
			
			//xml로 저장
			p.storeToXML(new FileOutputStream("data.xml"),"DB Info" );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("dbinfo.txt 파일 준비해주세요...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
