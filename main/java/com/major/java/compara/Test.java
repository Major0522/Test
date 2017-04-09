package com.major.java.compara;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// 新建ArrayList(动态数组)
		List<Person> list = new ArrayList<Person>();
		// 添加对象到ArrayList中
		list.add(new Person("ccc", 20));
		list.add(new Person("AAA", 30));
		list.add(new Person("bbb", 10));
		list.add(new Person("ddd", 40));

		// 打印list的原始序列
		System.out.printf("Original sort, list:%s\n", list);

		// 对list进行排序
		// 这里会根据“Person实现的Comparable<String>接口”进行排序，即会根据“name”进行排序
		Collections.sort(list);
		System.out.printf("Name sort, list:%s\n", list);

		// 通过“比较器(AscAgeComparator)”，对list进行排序
		// AscAgeComparator的排序方式是：根据“age”的升序排序
		Collections.sort(list, new AscAgeComparator());
		System.out.printf("Asc(age)  sort, list:%s\n", list);

		// 通过“比较器(DescAgeComparator)”，对list进行排序
		// DescAgeComparator的排序方式是：根据“age”的降序排序
		Collections.sort(list, new DescAgeComparator());
		System.out.printf("Desc(age) sort, list:%s\n", list);
	}
	
	private static void print(List<Person> persons){
		for(Person p : persons){
			System.out.println();
		}
		System.out.printf("Original sort, list:%s\n", persons.toString());
	}

	private static class AscAgeComparator implements Comparator<Person> {

		public int compare(Person p1, Person p2) {
			return p1.getAge() - p2.getAge();
		}

	}
	
	private static class DescAgeComparator implements Comparator<Person> {

		public int compare(Person p1, Person p2) {
			return p2.getAge() - p1.getAge();
		}

	}

}
