package com.major.java.compara;

public class Person implements Comparable<Person> {

	private int age;
	private String name;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @desc 实现 “Comparable<String>” 的接口，即重写compareTo<T t>函数。
	 *       这里是通过“person的名字”进行比较的
	 */
	public int compareTo(Person person) {
		return this.name.compareTo(person.getName());
	}

	public boolean equals(Person person) {
		if (person != null && this.age == person.getAge() && this.name == person.getName()) {
			return true;
		}
		return false;
	}
}
