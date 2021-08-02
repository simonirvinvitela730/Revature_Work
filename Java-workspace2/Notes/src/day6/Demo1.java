package day6;

import java.util.ArrayList;
import java.util.Collections;

public class Demo1 {
	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(2);
		numbers.add(1);
		numbers.add(4);
		numbers.add(3);
		numbers.add(5);
		
		System.out.println("before sorting..");
		for(int number: numbers) {
			System.out.println(number);
		}
		
		Collections.sort(numbers);
		System.out.println("after sorting..");
		for(int number: numbers) {
			System.out.println(number);
		}
	}
}
