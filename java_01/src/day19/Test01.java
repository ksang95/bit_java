package day19;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack=new Stack<String>();
		for(int i=0; i<100; i++) {
			stack.push(""+i);
		}
		System.out.println(stack.pop());
		
		Queue<Integer> queue=new LinkedList<Integer>();
		
		for(int i=0; i<100;i++) {
			queue.offer(i);
		}
		System.out.println(queue.poll());
	}
	
}
