package com.major.java.thread;

public class SyncTest {

	public static void main(String[] args) {
		Stack stack = new Stack("STACK");

		Producer producer = new Producer(stack, "P");
		Consumer consumer = new Consumer(stack, "C");
	}

}

class Consumer extends Thread {

	private Stack stack;

	public Consumer(Stack s, String name) {
		super(name);
		this.stack = s;
		start();
	}

	@Override
	public void run() {
		String goods;
		for (int i = 0; i < 200; i++) {
			if (!stack.isEmpty()) {
				goods = stack.pop();
				System.out.println(getName() + ":pop " + goods + " from " + stack.getName());
			}
			yield();
		}
	}
}

class Producer extends Thread {

	private Stack stack;

	public Producer(Stack s, String name) {
		super(name);
		stack = s;
		start();
	}

	@Override
	public void run() {
		String goods;
		for (int i = 0; i < 200; i++) {
			if (!stack.isFull()) {
				goods = "goods" + (stack.getPoint() + 1);
				stack.push(goods);
				System.out.println(getName() + ":push " + goods + " to " + stack.getName());
			}
			yield();
		}
	}
}

class Stack {

	private static final int MAX_NUM = 100;
	private String name;
	private String[] buffer = new String[MAX_NUM];
	private int point = -1;

	public Stack(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPoint() {
		return point;
	}

	public String pop() {
		String goods = buffer[point];
		buffer[point] = null;
		Thread.yield();
		point--;
		return goods;
	}

	public boolean isFull() {
		return point >= MAX_NUM;
	}

	public boolean isEmpty() {
		return point == 0;
	}

	public void push(String goods) {
		point++;
		buffer[point] = goods;
		Thread.yield();
	}
}
