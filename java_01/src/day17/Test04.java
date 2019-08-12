package day17;

import java.util.ArrayList;
import java.util.List;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list.add("hello");
		list.add("java");
		for(String data:list) {
			System.out.println(data.toUpperCase());
		}
	}

}
