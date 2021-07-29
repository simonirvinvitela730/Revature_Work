package day4;

import java.util.ArrayList;
import java.util.Collections;

public class Practice1 {
	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<>();
		colors.add("blue");
		colors.add("jade");
		colors.add("pink");
		colors.add("silver");
		colors.add("teal");
		
		System.out.println("Example One: ");
		System.out.println(colors); //1
		
		System.out.println("Example Two: ");
		for(String color: colors) { //2
			System.out.println(color);
		}
		
		System.out.println("Example Three: ");
		colors.add(0, "gold");  //3
		System.out.println(colors);
		
		System.out.println("Example Four: ");
		System.out.println(colors.get(3)); //4
		
		System.out.println("Example Five: ");
		colors.set(2, "orange"); //5
		System.out.println(colors);
		
		System.out.println("Example Six: ");
		colors.remove(2); //6
		System.out.println(colors);
		
		System.out.println("Example Seven: ");
		System.out.println(colors.contains("gold")); //7
		
		System.out.println("Example Eight: ");
		Collections.sort(colors); //8
		System.out.println(colors);
		
		System.out.println("Example Nine: ");
		ArrayList<String> newColors = new ArrayList<>();
		newColors.add("forest green");
		newColors.add("lavender");
		
		colors.addAll(0, newColors); //9
		System.out.println(colors);
		
	}
}
