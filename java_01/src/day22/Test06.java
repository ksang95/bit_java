package day22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("  파일 복사   .txt  ");
		String src = "c://lib//sample.txt";
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		try {
			fr = new FileReader(src);
			fw = new FileWriter("c://lib//copy.txt");
			br=new BufferedReader(fr);
			bw=new BufferedWriter(fw);
			String read=null;
			while((read=br.readLine())!=null) {
				bw.write(read+"\r\n");
			}
			bw.write("sample.txt 파일을 복사한 내용입니다.\r\n");
			bw.flush();
			System.out.println("파일 기록 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(src + " 파일(복사원본) 준비해주세요.");
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			try {
				if(br!=null)br.close();
				if(bw!=null)bw.close();
				if(fr!=null)fr.close();
				if(fw!=null)fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("  main end  ");
	}

}
