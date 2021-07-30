package day4;

import java.util.Iterator;
import java.util.LinkedList;

public class Practice3 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add("water");
		list.add("fire");
		list.addLast("earth"); //1
		
		for(int i=0; i<list.size(); i++) { //2
			System.out.println(list.get(i));
		}
		
	    Iterator iterator = list.listIterator(1); //3
	        while (iterator.hasNext()){
	            System.out.println(iterator.next());
	        }
		
		for(int i =(list.size() - 1); i>=0; i--) {//4
			System.out.println(list.get(i));
		}
		
		list.set(1, "air"); //5
		System.out.println(list);
		
		
	}
	
	
}
