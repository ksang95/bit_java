package day23;

public class Test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(Thread.MAX_PRIORITY);
		// System.out.println(Thread.MIN_PRIORITY);
		// System.out.println(Thread.NORM_PRIORITY);
		System.out.println(" Main start ");
		System.out.println(Thread.currentThread());
		Job1 j1 = new Job1();
		Thread t1 = new Thread(j1, "job1");
		Job2 j2 = new Job2();
		Thread t2 = new Thread(j2, "job2");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("홀수합 + 짝수합 = " + (j1.sum + j2.sum));
		System.out.println(" Main end ");
	}

}

class Job1 implements Runnable {
	int sum = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 100; i = i + 2) {
			sum += i;
			System.out.print(Thread.currentThread() + " ");
			System.out.println("1~" + i + " 홀수합 :" + sum);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Job2 implements Runnable {
	int sum = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i = i + 2) {
			sum += i;
			System.out.print(Thread.currentThread() + " ");
			System.out.println("0~" + i + " 짝수합 :" + sum);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}