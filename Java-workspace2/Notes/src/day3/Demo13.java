package day3;
/*
 * String Buffer Capacity
 */
public class Demo13 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.capacity());
		sb.append("hello");
		System.out.println(sb.capacity());
		sb.append("here are a lot of words to test this out blah blah blah blah");
		System.out.println(sb.capacity());
	}
}
