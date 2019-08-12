package day13;

public class Temp02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] x= {'a','b','c'};
		char[] y= {'h','e','l','l','o'};
		System.arraycopy(x, 2, y, x.length, 1);
		for(int inx=0;inx<y.length;inx++) {
			System.out.print(y[inx]);
		}
	}

}
