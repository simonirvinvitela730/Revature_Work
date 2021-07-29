package day4;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo8 {
	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<>();
		names.add("Mark");
		names.add("Paul");
		names.add("Watson");
		
		// adding element at specified position
		names.add(0, "John");
		System.out.println(names);
		
		LinkedList<String> namesNew = new LinkedList<>();
		namesNew.add("Stacy");
		namesNew.add("Smith");
		
		names.addAll(0, namesNew);
		System.out.println(names);
		
		//addFirst()
		names.addFirst("First");
		System.out.println(names);
		
		//addLast()
		names.addLast("Last");
		System.out.println(names);
		
		// removeFirst()
		// reomveLast()
		// removeFirstOccurence()
		// removeLastOccurence()
		
		names.addLast("Stacy");
		
		names.removeFirstOccurrence("Stacy");
		System.out.println(names);
		
		//traversing list element in reverse order
		Iterator i = names.descendingIterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}