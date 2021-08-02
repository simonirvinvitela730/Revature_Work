package day5;

public class Demo25 {
	public static void main(String[] args) {
		//try to convert all primitive types into its wrapper class
		
		byte a = 10;
		short b = 20;
		int c = 30;
		long d = 40;
		float e = 12.3f;
		double f = 12.24;
		char g = 'a';
		boolean h= true;
		
		// Autoboxing converting primitives into objects
		Byte byteObj = a;
		Short shortObj = b;
		Integer intObj = c;
		
		// unboxing: convert object into primitive 
		byte byteValue = byteObj;
		short shortValue = shortObj;
	}
}
