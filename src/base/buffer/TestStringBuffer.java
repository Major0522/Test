package base.buffer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStringBuffer {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("My");
		Matcher m = p.matcher("My dad and My mom");
		StringBuffer sb = new StringBuffer();
		boolean found = m.find();

		while (found) {
			m.appendReplacement(sb, "Our");
			found = m.find();

		}
//		m.appendTail(sb);
		System.out.println(sb);
	}

}
