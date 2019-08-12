package day23;

public class Test09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(Thread.MAX_PRIORITY);
		// System.out.println(Thread.MIN_PRIORITY);
		// System.out.println(Thread.NORM_PRIORITY);
		System.out.println(" Main start ");
		System.out.println(Thread.currentThread());
		T1 t1 = new T1();
		T2 t2 = new T2();
		t1.start();
		t2.start();
		
		System.out.println(" Main end ");
	}

}

class T1 extends Thread {
	int sum = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 100; i = i + 2) {
			sum += i;
			System.out.print(Thread.currentThread() + " ");
			System.out.println("1~" + i + " 홀수합 :" + sum);
		}
	}

}

class T2 extends Thread {
	int sum = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i = i + 2) {
			sum += i;
			System.out.print(Thread.currentThread() + " ");
			System.out.println("0~" + i + " 짝수합 :" + sum);
		}
	}

}