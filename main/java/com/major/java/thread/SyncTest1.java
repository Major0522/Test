package com.major.java.thread;

public class SyncTest1 {
	
	public static void main(String[] args) {
		Well well = new Well();
		
		Person persons[] = new Person[10];
		for (int i = 0; i < 10; i++) {
			persons[i] = new Person(well);
		}
	}

}

class Person extends Thread {

	private Well well;
	
	public Person(Well well){
		this.well = well;
		start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			int left = well.withd();
			
			System.out.println(getName() + ":Get:" + i + ";Well left:" + left);
		}
	}
}

class Well {
	private int left = 1000;

	public synchronized int withd() {
		return left--;
	}
}
