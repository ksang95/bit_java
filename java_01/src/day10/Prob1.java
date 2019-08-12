package day10;

public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student st=new Student("홍길동",20,200201);
		Teacher tc=new Teacher("이순신",30,"JAVA");
		Employee ep=new Employee("유관순",40,"교무과");
		st.print();
		tc.print();
		ep.print();
	}

}
