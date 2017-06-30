package kdata.collections;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<String> list = new ArrayList<String>(); //new ArrayList<String>();에서 String 생략 가능 -> new ArrayList<>();
		List<String> list = new ArrayList<>(); //이렇게도 많이 사용
		
		list.add("2");
		list.add("Hello");
		list.add("Hello");

		System.out.println(list); // overriding

		/*
		 * Object o = list.get(0); Integer i = (Integer) o;
		 * 
		 * Object o2 = list.get(1); String s = (String) o2;
		 * 
		 * System.out.println(list.size());
		 */

		/*
		 * for(int i=0; i<list.size(); i++){ System.out.println(list.get(i)); }
		 */

		for (String s : list) { // 위의 for문과 같은 결과 - 배열, 컬렉션에서 많이 사용
			System.out.println(s);
		}
	}

}
