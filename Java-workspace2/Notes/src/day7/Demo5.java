package day7;

class GenericMethodDemo{
	public static <E> void printArray(E[] elements) {
		for(E element: elements) {
			System.out.println(element);
		}
		System.out.println("***********");
	}
}
public class Demo5 {
	public static void main(String[] args) {
	Integer[] intArray = {10, 20, 30, 40};
	Character[] charArray = {'a', 'b', 'c', 'd'};
	
	GenericMethodDemo.printArray(intArray);
	GenericMethodDemo.printArray(charArray);
	}
}
