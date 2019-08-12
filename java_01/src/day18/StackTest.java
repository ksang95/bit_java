package day18;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack stack = new MyStack(10);
		if (stack.isEmpty()) {
			System.out.println("스택이 비어있습니다.");
		}

		for (int i = 1; i <= 10; i++)
			stack.push(i);
		if (stack.isFull()) {
			System.out.println("스택이 가득 찼습니다.");
		}

		System.out.println("최상위 숫자 : " + stack.top());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("");
		System.out.println("== 스택 리스트 ==");
		for (int i = 1; i <= 10; i++) {
			int num = stack.pop();
			if (num != -1)
				System.out.println(num);
		}
	}

}

class MyStack {
	int size;
	int stack[];
	int top;

	public MyStack() {
		size = 10;
		stack = new int[size];
	}

	public MyStack(int size) {
		super();
		if (size < 0)
			this.size = 10;
		else
			this.size = size;
		stack = new int[size];
	}

	void push(int num) {
		if (!isFull())
			stack[top++] = num;
	}

	boolean isEmpty() {
		if (top == 0)
			return true;
		else
			return false;
	}

	boolean isFull() {
		if (top == size)
			return true;
		else
			return false;
	}

	int top() {
		if (!isEmpty()) {
			return stack[top - 1];
		}
		return -1;
	}

	int pop() {
		int num = -1;
		if (!isEmpty()) {
			num = stack[--top];
		}
		return num;
	}
}