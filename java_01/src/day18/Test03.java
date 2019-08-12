package day18;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] s = new Student[10];
		Student[] sss= {new Student("홍길동", 80, 50),new Student("고길동", 100, 80),new Student("김길동", 75, 85),new Student("강길동", 35, 90)};
		Arrays.sort(sss);
		Vector<Student> list = new Vector<Student>(5,10);
		System.out.println("capacity :"+list.capacity());
		System.out.println("size :"+list.size());
		list.add(new Student("홍길동", 80, 50));
		list.add(new Student("고길동", 100, 80));
		list.add(new Student("김길동", 75, 85));
		list.add(new Student("강길동", 35, 90));
		list.add(new Student("이길동", 50, 70));
		list.add(new Student("이길동", 50, 70));
		list.add(new Student("이길동", 50, 70));
		list.add(new Student("이길동", 50, 70));
		list.add(new Student("이길동", 50, 70));
		list.add(new Student("이길동", 50, 70));
		list.add(new Student("이길동", 50, 70));
		System.out.println("capacity :"+list.capacity());
		System.out.println("size :"+list.size());
		// System.out.println(list);
		Iterator<Student> it = list.iterator();
		while (it.hasNext()) {
			Student data = it.next();
			if (data.getAvg() >= 90)
				System.out.println(data);
		}
		System.out.println(list.contains(new Student("김길동", 75, 85)));

		// C(등록) U(수정) R(검색) D(삭제)
		Student s1 = new Student("왕길동", 90, 90);
		boolean flag = list.add(s1);
		if (flag)
			System.out.println(s1 + " 등록되었습니다.");
		else
			System.out.println(s1 + " 등록이 실패하였습니다.");
		
		it = list.iterator();
		while (it.hasNext()) {
			Student data = it.next();
			if (data.getName().equals("왕길동")) {
				data.setKo(100);
				data.setMath(100);
				data.setAvg();
				System.out.println(data+" 수정되었습니다.");
			}
		}
		
		
		System.out.println("*** 학생 list 정보 출력 ***");
		it = list.iterator();
		while (it.hasNext()) {
			Student data = it.next();
			System.out.println(data);
		}
		
		it = list.iterator();
		while (it.hasNext()) {
			Student data = it.next();
			if (data.equals(s1)) {
				it.remove();
				System.out.println(s1+" 삭제되었습니다.");
			}
		}
		
		
		Collections.sort(list);
		System.out.println("*** 학생 list 정보 출력 ***");
		it = list.iterator();
		while (it.hasNext()) {
			Student data = it.next();
			System.out.println(data);
		}
		
	}

}
