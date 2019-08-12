package day06;

class Student {
	private int num;
	private String name;
	private String college;
	private String department;

	Student(int num, String name, String college, String department) {
		this.num = num;
		this.name = name;
		this.college = college;
		this.department = department;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s[]=new Student[2];
		s[0]=new Student(1503032,"김홍도", "조형예술대학", "동양화과");
		s[1]=new Student(1702089,"홍길동","인문과학대학","국어국문학과");
		for(int i=0; i<s.length; i++) {
			System.out.println("학번: "+s[i].getNum()+", 이름: "+s[i].getName()+", 소속대학: "+s[i].getCollege()+", 학과/전공: "+s[i].getDepartment());
		}
		s[0].setCollege("자연과학대학");
		s[0].setDepartment("생명과학과");
		s[1].setName("홍정호");
		for(int i=0; i<s.length; i++) {
			System.out.println("학번: "+s[i].getNum()+", 이름: "+s[i].getName()+", 소속대학: "+s[i].getCollege()+", 학과/전공: "+s[i].getDepartment());
		}
	}

}
