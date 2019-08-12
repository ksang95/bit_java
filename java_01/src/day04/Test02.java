package day04;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int j=0; j<5; j++) {
			for(int i=j; i>=0; i--)
				System.out.print("*");
			System.out.println();
		}
		for(int j=0; j<5; j++) {
			for(int i=5-j; i>0; i--)
				System.out.print("*");
			System.out.println();
		}
	}

}
