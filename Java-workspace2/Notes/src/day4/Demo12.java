package day4;

import java.util.TreeSet;

public class Demo12 {
	public static void main(String[] args) {
		TreeSet<Integer> num = new TreeSet<>();
		num.add(11);
		num.add(2);
		num.add(15);
		num.add(21);
		num.add(65);
		
		for(int number: num) {
			System.out.println(number);
		}
		
		System.out.println("Highest: "+ num.pollLast());
		System.out.println("Lowest: "+ num.pollFirst());
	}
}