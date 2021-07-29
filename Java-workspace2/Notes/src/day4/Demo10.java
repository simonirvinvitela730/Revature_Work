package day4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Demo10 {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("One");
		set.add("Two");
		set.add("Three");
		set.add("Four");
		set.add("Five");
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		LinkedHashSet<String> lSet = new LinkedHashSet<>();
		lSet.add("One");
		lSet.add("Two");
		lSet.add("Three");
		lSet.add("Four");
		lSet.add("Five");
		
		Iterator<String> niterator = lSet.iterator();
		while (niterator.hasNext()) {
			System.out.println(niterator.next());
		}
	}
}
