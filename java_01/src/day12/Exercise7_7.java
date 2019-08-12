package day12;

public class Exercise7_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child2 c = new Child2();
		System.out.println("x=" + c.getX());
		System.out.println(c.x);
	}

}

class Parent2 {
	int x = 100;

	Parent2() {
		this(200);
	}

	Parent2(int x) {
		this.x = x;
	}

	int getX() {
		return x;
	}
}

class Child2 extends Parent2 {
	int x = 3000;

	Child2() {
		this(1000);
	}

	Child2(int x) {
		this.x = x;
	}
}
