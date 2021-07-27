package day2;
/*
 * Static block - will execute before main
 */
class Test{

}


public class Demo5 {

    static {
        System.out.println("Static block");
    }

    public static void main(String[] args) {
        System.out.println("Main method");
    }
}
