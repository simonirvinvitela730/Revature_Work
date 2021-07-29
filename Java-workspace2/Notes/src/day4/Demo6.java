package day4;

import java.util.ArrayList;

public class Demo6 {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		
		names.add("Mark");
        names.add("Paul");
        names.add("Stacy");
        names.add("Watson");
        
        System.out.println(names.get(1));
        
        names.add(1, "John");
        System.out.println(names);
        
        ArrayList<String> newNames = new ArrayList<>();
        
        newNames.add("Reggie");
        newNames.add("Wayne");
        
        names.addAll(newNames);
        System.out.println(names);
        
        names.addAll(0, newNames);
        System.out.println(names);
        
        
        //names.remove("Mark");
      //names.remove("0");
        
        names.removeAll(newNames);
        System.out.println(names);
        
        names.removeIf(name -> name.contains("Paul"));
        
	}
}
