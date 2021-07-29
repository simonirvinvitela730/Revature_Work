package day4;

import java.util.HashSet;
import java.util.Iterator;

public class Demo9 {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("Mark");
		set.add("Paul");
		set.add("Watson");
		set.add(null);
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		//remove()
		set.remove("Paul");
		System.out.print(set);
		
		//removeAll()
		//removeIf()
		//clear()
		//addAll()
	}
}
