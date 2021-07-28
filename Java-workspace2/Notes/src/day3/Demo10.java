package day3;
/*
 * using split method
 */
import java.util.Arrays;

public class Demo10 {
    public static void main(String[] args) {
        String message = "Hello, welcome to java";
        String[] result = message.split(" ");
        System.out.println(Arrays.toString(result));
    }
}
