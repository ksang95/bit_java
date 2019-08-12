package day18;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Employee> set=new TreeSet<Employee>();
		boolean flag=set.add(new Employee(2017001,"홍씨","영업부"));
		if(flag) System.out.println("등록되었습니다.");
		flag=set.add(new Employee(2017001,"홍씨","영업부"));
		if(!flag) System.out.println("이미 있는 데이터입니다.");
		set.add(new Employee(2017002,"김씨","마케팅부"));
		set.add(new Employee(2017003,"박씨","기술부"));
		
		System.out.println("사원 목록입니다.");
		Iterator<Employee> it=set.iterator();
		while(it.hasNext()) {
			Employee data=it.next();
			System.out.println(data);
		}
		
		it=set.iterator();
		System.out.println("검색결과입니다.");
		while (it.hasNext()) {
			Employee data = (Employee) it.next();
			if(data.number==2017003)
				System.out.println(data);
		}
	}

}