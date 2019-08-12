package day11;

import day10.Animal;
import day10.Dog;

public class AnimalTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal[] a = { new Dog("진돗개", "쫑이"), new Fish("구피"), new Dog("시베리안허스키", "케리") };
	
	//	for(Animal data:a) {
	//		data.breath();
	//		data.print();
	//	}
	//	Dog a1=new Dog("진돗개", "쫑이");
	//	callD(a1);
	//	Fish f1=new Fish("구피");
	//	callD(f1);
		for(Animal data:a) {
			callD(data);
		}
	}
	
	public static void callD(Dog a) {
		a.breath();
		a.print();
	}
	public static void callD(Fish a) {
		a.breath();
		a.print();
	}
	public static void callD(Animal a) {
		a.breath();
		a.print();
	}

}
