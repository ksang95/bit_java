package day11;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object a = new Student("홍길동", 20, 2012001);
		Object t = new Teacher("이순신", 30, "JAVA");
		Object e = new Employee("유관순", 40, "교무과");
		// is a
		Person p = (Person)a;
		//p.printA();
		((Student)p).print();
		((Student)p).print();
	}

}

class Person {
	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		super();
		this.setName(name);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void print() {
		System.out.printf("이름 : %s , 나이 : %2d", this.name, this.age);
	}
}

class Student extends Person {
	private int id;

	public Student() {
	}

	public Student(String name, int age, int id) {
		super(name, age);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void print() {
		super.print();
		System.out.printf(" , 학번 : %s\n", id);
	}
}

class Teacher extends Person {
	private String subject;

	public Teacher() {
	}

	public Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void print() {
		super.print();
		System.out.printf(" , 담당과목: %s\n", subject);
	}
}

class Employee extends Person {
	private String dept;

	public Employee() {
	}

	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void print() {
		super.print();
		System.out.printf(" , 부서: %s\n", dept);
	}
}
