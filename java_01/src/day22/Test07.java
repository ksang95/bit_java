package day22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		BufferedReader br = null;
		String src = "c:\\lib\\dbinfo.txt";
		try {
			fr = new FileReader(src);
			br = new BufferedReader(fr);
			String read = null;
			String id = null;
			String pw = null;
			while ((read = br.readLine()) != null) {
				String[] data=read.split("=");
				if (data[0].equals("user")) {
					id = data[1];
				}
				if (data[0].equals("pw")) {
					pw =  data[1];
				}
			}
			System.out.println("로그인 시도");
			System.out.println("ID: "+id+", PW: "+pw);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(src + " 파일(복사원본) 준비해주세요.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(br!=null)br.close();
				if(fr!=null)fr.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("  main end  ");
	}

}
