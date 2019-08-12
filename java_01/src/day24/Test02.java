package day24;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start");
		MyStack ms = new MyStack();
		Push job1 = new Push(ms);
		Pop job2 = new Pop(ms);
		Thread push = new Thread(job1,"push");
		Thread pop = new Thread(job2,"pop");
		push.start();
		pop.start();
		System.out.println("main end");
	}

}

class Pop implements Runnable {
	MyStack ms;

	public Pop() {
	}

	public Pop(MyStack ms) {
		super();
		this.ms = ms;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			ms.pop();
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Push implements Runnable {
	MyStack ms;

	public Push() {
	}

	public Push(MyStack ms) {
		super();
		this.ms = ms;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			ms.push(i);
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}