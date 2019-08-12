package day07;

public class Prob1 {

	public String leftPad(String str, int size, char padChar) {
		for (; str.length() < size;)
			str = padChar + str;
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob1 prob1=new Prob1();
		System.out.println(prob1.leftPad("bit", 6, '#'));
		System.out.println(prob1.leftPad("bit", 5, '$'));
		System.out.println(prob1.leftPad("bit", 2, '&'));
	}

}
