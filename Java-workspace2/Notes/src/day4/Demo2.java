package day4;

import java.util.ArrayList;

public class Demo2 {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("Mark");
		names.add("Steve");
		names.add("Watson");
		
		System.out.println(names);
		
		names.set(2, "Jacob");
		
		for(String name: names) {
			System.out.println(name);
		}
		
	}
}
