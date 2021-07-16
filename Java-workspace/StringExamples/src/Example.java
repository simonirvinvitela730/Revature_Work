
public class Example {
	public static int n = 300_000;
	public static void main(String[] args) {
		manyStringBuilder();
	}
	public static void manyStringBuilder() {
		StringBuilder sb = new StringBuilder("");
		long start = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			sb.append("a");
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start + " ms");
	}
}
