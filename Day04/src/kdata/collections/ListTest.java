package kdata.collections;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<String> list = new ArrayList<String>(); //new ArrayList<String>();���� String ���� ���� -> new ArrayList<>();
		List<String> list = new ArrayList<>(); //�̷��Ե� ���� ���
		
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

		for (String s : list) { // ���� for���� ���� ��� - �迭, �÷��ǿ��� ���� ���
			System.out.println(s);
		}
	}

}
