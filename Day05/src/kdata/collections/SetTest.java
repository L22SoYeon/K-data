package kdata.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> set = new HashSet<>();
		
		set.add("1");
		set.add("1");
		set.add("2");
		
		System.out.println(set);
		
		System.out.println("");
		
		for(String s : set){
			System.out.println(s);
		}
		
		System.out.println("");
		
		//Iterator<String> it = set.iterator();
		
	}

}
