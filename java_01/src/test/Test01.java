package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test01 implements Comparable<Test01> {
	String name;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			BufferedReader bis=new BufferedReader(new FileReader("naver.html"));
			String read=null;
			while((read=bis.readLine())!=null) {
				System.out.println(read);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
		String msg="hello java";
		System.out.print("1");
		try {
			System.out.print("2");
			if(msg==null)
				throw new Exception();
			System.out.print(3/0);
			System.out.print("3");
		}catch(RuntimeException e) {
			System.out.print("4");
		}catch(Exception e) {
			System.out.print("5");
		}finally {
			System.out.print("6");
		}
		System.out.print("7");
	}




	@Override
	public int compareTo(Test01 o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

}
