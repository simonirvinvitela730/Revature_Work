package day4;

import java.util.HashSet;
import java.util.Iterator;

public class Practice4 {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("e");
		
		/*Question 1
		 * Adding an element to the end of a HashSet is impossible 
		 * because HashSets do not maintain insertion order and are 
		 * inserted on the basis of their hash code. On the other hand,
		 * a LinkedHashSet does follow insertion order and could perform 
		 * this task.
		 */
		
		Iterator iterator = set.iterator(); //2
		while(iterator.hasNext()) {
			System.out.println(iterator.next()); 
		}
		
		System.out.println(set.size()); //3
		
		set.clear(); //4
		System.out.println(set);
	}
	
}
