package day4;
import java.util.ArrayList;
import java.util.Iterator;
/*
 * ArrayList has type safety can only do an array of one datatype
 */
public class Demo1 {
	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<>();
		
		aList.add("Mark");
		aList.add("Paul");
		aList.add("Watson");
		
		//System.out.println(aList);
		
		Iterator i = aList.iterator();
		while(i.hasNext()) {
			System.out.println(i.next()); // print the element and move the cursor to the next element
		}
		
		for(String name: aList) {
			System.out.println(name);
		}
	}
}
