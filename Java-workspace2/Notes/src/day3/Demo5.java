package day3;
/*
 * compareTo Method
 */
public class Demo5 {
    public static void main(String[] args) {
        String s1 = "Mark";
        String s2 = "Mark";
        String s3 = "Paul";
        String s4 = new String("Mark");

        System.out.println(s1.compareTo(s2)); // 0
        System.out.println(s1.compareTo(s3));  // -
        System.out.println(s3.compareTo(s1)); // +
        System.out.println(s1.compareTo(s4)); // 0
    }
}