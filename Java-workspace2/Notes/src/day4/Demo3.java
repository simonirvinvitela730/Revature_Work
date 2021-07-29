package day4;
/*
 * Sorting ArrayLists
 */
import java.util.ArrayList;
import java.util.Collections;

public class Demo3 {
	public static void main(String[] args) {
		
		ArrayList<String> colors = new ArrayList<>();
		colors.add("yellow");
		colors.add("red");
		colors.add("orange");
		colors.add("blue");
		colors.add("pink");
		
		System.out.println("before sorting...");
		
		for(String color: colors) {
			System.out.println(color);
		}
		
		Collections.sort(colors);
		System.out.println("after sorting...");
		for(String color: colors) {
			System.out.println(color);
		}
		
		 // List of numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(8);
        numbers.add(2);
        numbers.add(1);
        numbers.add(5);
        numbers.add(6);

        // before sort
        System.out.println("before sorting...");
        for(int number: numbers){
            System.out.println(number);
        }

        // after sort
        Collections.sort(numbers);
        System.out.println("after sorting...");
        for(int number: numbers){
            System.out.println(number);
        }

	}
}
