package day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] s = new Student[10];
		Student[] sss= {new Student("홍길동", 80, 50),new Student("고길동", 100, 80),new Student("김길동", 75, 85),new Student("강길동", 35, 90)};
		Arrays.sort(sss);
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", 80, 50));
		list.add(new Student("고길동", 100, 80));
		list.add(new Student("김길동", 75, 85));
		list.add(new Student("강길동", 35, 90));
		list.add(new Student("이길동", 50, 70));
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

class Student extends Object implements Comparable<Student> {
	String name;
	int ko;
	int math;
	double avg;

	public Student() {
		super();
	}

	public Student(String name, int ko, int math) {
		super();
		this.name = name;
		this.ko = ko;
		this.math = math;
		setAvg();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKo() {
		return ko;
	}

	public void setKo(int ko) {
		this.ko = ko;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg() {
		this.avg = (ko + math) / 2;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", ko=" + ko + ", math=" + math + ", avg=" + avg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ko;
		result = prime * result + math;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(avg) != Double.doubleToLongBits(other.avg))
			return false;
		if (ko != other.ko)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		// return -(int)(avg-o.avg);
		return name.compareTo(o.name);
	}

}