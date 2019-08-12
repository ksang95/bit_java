package day19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,Employee> map=new HashMap<Integer, Employee>();
		Employee[] emp= {new Employee(2017002,"김씨","마케팅부"),new Employee(2017003,"박씨","기술부")};
		
		
		map.put(2017002,new Employee(2017002,"김씨","마케팅부"));
		map.put(2017009,new Employee(2017009,"김씨","마케팅부"));
		map.put(2017012,new Employee(2017012,"홍씨","영업부"));
		map.put(2018002,new Employee(2018002,"박씨","마케팅부"));
		map.put(2019002,new Employee(2019002,"김씨","영업부"));
		
		System.out.println(map);
		System.out.println("2018002 사번의 사원 조회 내역");
		System.out.println(map.get(2018002));
		
		System.out.println("마케팅부 사원 목록 출력");
		Set<Integer> keys=map.keySet();
		Iterator<Integer> it=keys.iterator();
		while(it.hasNext()) {
			Integer key=it.next();
			Employee e=map.get(key);
			if(e.dept.equals("마케팅부"))
				System.out.println(e);
		}
		
		System.out.println("2018002 사번의 사원 삭제(퇴사처리)");
		System.out.println("삭제 정보 : "+map.remove(2018002));
		System.out.println("2018002 사번의 사원 정보 : "+map.get(2018002));
	}

}

