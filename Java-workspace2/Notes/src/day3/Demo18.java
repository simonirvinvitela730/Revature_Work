package day3;
/*
 * Try and Catch Blocks
 */
public class Demo18 {
    public static void main(String[] args) {

        int a  = 20;
        int b = 10;
        int c = 0;

        try{
            c = a / b;
        }
        catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception ex){

        }


        System.out.println(c);



    }
}

