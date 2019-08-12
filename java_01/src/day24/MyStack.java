package day24;

public class MyStack {
	int[] stack;
	int top = 0;

	public MyStack() {
		stack = new int[10];
	}

	public MyStack(int size) {
		if (size < 0)
			stack = new int[10];
		else
			stack = new int[size];
	}

	public synchronized boolean isEmpty() {
		return top == 0 ? true : false;
	}

	public synchronized boolean isFull() {
		return top == stack.length ? true : false;
	}

	public synchronized void push(int data) {
		if (isFull()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		stack[top] = data;
		top++;
		System.out.println("push => " + data);
		notifyAll();
	}

	public synchronized int pop() {
		if (isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int data = stack[--top];
		System.out.println("                    pop => " + data);
		notifyAll();
		return data;
	}

	public synchronized int top() {
		if (isEmpty())
			return -1;
		return stack[top - 1];
	}
}
