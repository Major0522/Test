package com.major.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest {

	public static void main(String[] args) {
		Class clazz = null;
		try {
			clazz = Class.forName("java.lang.Integer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		StringBuffer sb = new StringBuffer();
		sb.append(Modifier.toString(clazz.getModifiers()) + " class " + clazz.getSimpleName() + "{\n");

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			sb.append("\t");
			sb.append(Modifier.toString(field.getModifiers()) + " ");// 获得属性的修饰符，例如public，static等等
			sb.append(field.getType().getSimpleName() + " ");// 属性的类型的名字
			sb.append(field.getName() + ";\n");// 属性的名字+回车

		}
		sb.append("}");
		System.out.println(sb);
	}
}