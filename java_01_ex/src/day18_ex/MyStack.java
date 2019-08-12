package day18_ex;

public class MyStack<E> {
	E[] stack;
	int top=0;
	
	MyStack() {
		stack = (E[])new Object[10];
	}

	MyStack(int size) {
		if (size < 0)
			stack = (E[])new Object[10];
		else
			stack = (E[])new Object[size];
	}

	boolean isEmpty() {
		return top == 0 ? true : false;
	}

	boolean isFull() {
		return top == stack.length ? true : false;
	}

	void push(E data) {
		if (isFull()) {
			System.out.println("stack is full ...");
			return;
		}
		stack[top] = data;
		top++;
	}
	
	E pop() {
		if(isEmpty()) return null;
		return stack[--top];
	}
	
	E top() {
		if(isEmpty()) return null;
		return stack[top-1];
	}
	
}
