package day24;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("main start");
		Account account = new Account("2019001", "홍길동", 99000);
		Job1 j1=new Job1(account);
		Job1 j2=new Job1(account);
		Thread t1=new Thread(j1,"통장");
		Thread t2=new Thread(j2,"카드");
		t1.start();
		t2.start();
		
		System.out.println("main end");
	}

}

class Job1 implements Runnable {
	Account ac;

	public Job1() {
	}

	public Job1(Account ac) {
		super();
		this.ac = ac;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			int money = ((int) (Math.random() * 7) + 1) * 1000;
			ac.withdraw(money);
		}
	}

}

class Account {
	String number;
	String name;
	int money;

	public Account() {
	}

	public Account(String number, String name, int money) {
		super();
		this.number = number;
		this.name = name;
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", name=" + name + ", money=" + money + "]";
	}

	public synchronized void withdraw(int money) {
		System.out.println(" ***** 출금 " + money + " ***** ");
		System.out.println(Thread.currentThread());
		if (this.money >= money) {
			this.money -= money;
			System.out.println("잔고: " + this.money);
			System.out.println("출금 완료: " + money);
			System.out.println("잔고: " + this.money);
		} else {
			System.out.println("잔액 부족");
		}
		System.out.println("***************************");
	}

}