package day3;
/*
 * Throwing Exceptions
 */
class EmployeeException extends RuntimeException{

}

public class Demo19 {
    public static void main(String[] args) {
        //throw new ArithmeticException();
        throw new EmployeeException();
    }
}