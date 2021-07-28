package day3;
/*
 * Substring method-using 2 numbers is a start and end point 
 * Using 1 number is a starting point
 */
public class Demo8 {
    public static void main(String[] args) {
        String message = "Welcome to java training";
        System.out.println(message.substring(0, 7));  // Welcome

        System.out.println("Original message: "+ message);
        System.out.println("Substring starting from index 7: "+ message.substring(7));
        System.out.println("Substring starting from index 0 to 7: "+ message.substring(0,7));

        String str = new String("Welcome Home");
        System.out.println(str);
        System.out.println(str.substring(8));

    }
}