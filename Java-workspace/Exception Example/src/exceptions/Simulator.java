package exceptions;

public class Simulator {
	public static void main(String[] args) {
		try{System.out.println(sumOddNumbers(4,5));
		} catch (EvenNumberException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Using a throws  is known as ducking the 
	 * exception. This means that we will not resolve the issue
	 * directly within this method, but rather will communicate
	 * to the location that invokes this method, the the issue
	 * must be resolved This is used to consolidate try-catch
	 * blocks in your code, to a single location.
	 */
	public static int sumOddNumbers(int a, int b) throws EvenNumberException{
		if (a % 2 == 0) {
			throw new EvenNumberException("First Input was Even");
		}else if (b % 2 == 0) {
			throw new EvenNumberException("Second Input was Even");
		}
		
		return a + b;
	}
}
