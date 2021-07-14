	import java.util.Scanner;

	public class ExampleOne {

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        System.out.println("Please type in a line and hit Enter.");

	        String line = in.nextLine();
	        System.out.println("You have typed: " + line);

	        in.close();
	        
	        String numbers = "1 2 3 5 7 9";

	        in = new Scanner(numbers);

	        while (in.hasNextInt()) {
	            System.out.print(in.nextInt());
	        }

	        in.close();
	    }
	}
