package day3;
/*
 * String Builder - has the same methods as String Buffer 
 * But is non synchronized
 */
public class Demo14 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hello");
		sb.append("World");
		System.out.println(sb);
	}
}
