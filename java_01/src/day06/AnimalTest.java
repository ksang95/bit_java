package day06;

class Animal{
	boolean live;
	int age;
	String name;
	
	void setName(String name) {
		this.name=name;
	}

	String getName() {
		return name;
	}
	
	boolean isLive() {
		return live;
	}
}

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal ani=new Animal();
		ani.age=3;
		ani.name="큰뿔소";
		ani.live=true;
		System.out.println("이름: "+ani.getName());
		System.out.println("생존여부: "+ani.isLive());
		ani.setName("펭귄");
		System.out.println("이름: "+ani.getName());
		System.out.println("생존여부: "+ani.isLive());
	}

}
