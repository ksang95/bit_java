package day10;

public class Dog extends Animal {
	private String kind="강아지 종류";
	private String name="강아지 이름";
	
	public Dog() {
		super("강아지과");
	}
	
	public Dog(String kind, String name) {
		super("강아지과");
		this.kind = kind;
		this.name = name;
	}
	
	public Dog(String superKind, String kind, String name) {
		super(superKind);
		this.kind=kind;
		this.name=name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void dogPrint() {
		System.out.printf("[%s:%s:%s]\n",super.kind,kind,name);
	}
	
	public String getSuperKind() {
		return super.kind;
	}
	
	public void print() {
		//dogPrint();
		super.print();
		System.out.printf("%s:%s\n",kind, name);
	}
	
}
