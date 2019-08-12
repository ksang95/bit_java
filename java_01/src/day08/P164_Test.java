package day08;

public class P164_Test {
	public static void main(String[] args) {
        Count c1 = new Count();
        Count c2 = new Count();
        Count c3 = new Count();
        Count c4 = new Count();
        System.out.println(Count.count);
        
	}
}

class Count{
	int c;
	static int count;
	public Count(){
		c++;
		count++;
	}
}
