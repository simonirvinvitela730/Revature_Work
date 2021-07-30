package day4;

import java.util.Iterator;
import java.util.TreeSet;

public class Practice5 {
	public static void main(String[] args) {
		TreeSet tree = new TreeSet();
		tree.add("Aardvark");
		tree.add("Crocodile");
		tree.add("Elephant");
		tree.add("Giraffe");
		tree.add("Iguana");
		
		System.out.println(tree);//1
		
		Iterator<String> iterator = tree.iterator();//2
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		TreeSet newTree = new TreeSet();//3
		newTree.add("Kangaroo");
		newTree.add("Monkey");
		
		tree.addAll(newTree);
		
		Iterator<String> i = tree.descendingIterator();//4
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		System.out.println(tree.pollFirst());//5
		System.out.println(tree.pollLast());
		
	}
	
}
