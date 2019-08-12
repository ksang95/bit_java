package day15;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A a=new A();
		A.B b=new A().new B();
		b.print();
		a.p();
		A.C.print();
	}

}

class A{
	String name="A";
	static int a=10;
	public A() {
		super();
	}
	public A(String name) {
		super();
		this.name = name;
	}
	void p() {
		System.out.println("A에서 호출");
		new B().print();
	}
	class B{
		String name="B";
		void print() {
			System.out.println(this.name);
			System.out.println(A.this.name);
		}
	}
	
	static class C{
		static void print() {
			System.out.println("~~~~");
			System.out.println(A.a);
		}
	}
	
	class D{
		void p() {
			class E{
				
			}
		}
	}
}
