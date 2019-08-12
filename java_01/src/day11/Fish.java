package day11;

import day10.Animal;

public class Fish extends Animal {
	private String name;
	
	public Fish() {
		super("물고기");
	}

	public Fish(String name) {
		super("물고기");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void fishPrint() {
		System.out.printf("[%s:%s]\n",kind,name);
	}
	@Override
	public void breath() {
		System.out.println(kind+" : 아가미로 숨쉬기~~~~");
	}
	
	public void print() {
		//fishPrint();
		super.print();
		System.out.printf("%s\n", name);
	}
}
