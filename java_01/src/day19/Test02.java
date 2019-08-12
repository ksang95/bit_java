package day19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("java01", "1234");
		map.put("java02","1234");
		map.put("admin","admin");
		for(int i=0;i<30;i++) {
			map.put("test"+i, (int)(Math.random()*3)+"00");
		}
		System.out.println(map);
		System.out.println("admin: "+map.get("admin"));
		System.out.println("java01: "+map.get("java01"));
		System.out.println("java09: "+map.get("java09"));
		System.out.println("test1: "+map.get("test1"));
		System.out.println("===========================================");
		Set<String> keynames=map.keySet();
		Iterator<String> it=keynames.iterator();
		while(it.hasNext()) {
			String key=it.next();
			System.out.println("ID: "+key+", PW: "+map.get(key));
		}
		
	}

}
