package day4;

import java.util.TreeSet;

public class Demo11 {
	public static void main(String[] args) {
		TreeSet<String> tree = new TreeSet<>();
		tree.add("Mark");
		tree.add("Watson");
		tree.add("John");
		tree.add("Apple");
		
		for(String name: tree) {
			System.out.println(name);
		}
	}
}
