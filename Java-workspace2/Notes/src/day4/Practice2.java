package day4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Practice2 {
	public static void main(String[] args) {
		Map map = new HashMap();//1
		map.put("hello", "world");
		map.put(1, "yellow");
		
		Set set = map.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry entry = (Map.Entry)iterator.next();
			System.out.println(entry.getKey() + " : "+ entry.getValue());
		}
		
		
		System.out.println(map.size());//2
		
		
		Map map2 = new HashMap();//3
		map2.put(3, "thing");
		
		map.putAll(map2);
		
		Iterator iterator2 = set.iterator();
		while(iterator2.hasNext()) {
			Map.Entry entry = (Map.Entry)iterator2.next();
			System.out.println(entry.getKey() + " : "+ entry.getValue());
		}
	}
	
}
