package kdata.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Vehicle> list = new ArrayList<>();

		// 이름이 필요할 때 사용
		Vehicle v = new Vehicle(1, "red");
		list.add(v);

		// 이름이 필요 없을 때 사용
		list.add(new Vehicle(1, "blue"));

		System.out.println(list);

		System.out.println("--1--");

		for (int i = 0; i < list.size(); i++) {
			Vehicle v2 = list.get(i);
			System.out.print(v2.getNum());
			System.out.println(v2.getColor());
		}

		System.out.println("--2--");

		// 확장 for문
		for (Vehicle v3 : list) {
			System.out.println(v3.getNum());
			System.out.println(v3.getColor());
		}

		System.out.println("--3--");

		// Iterator
		Iterator<Vehicle> it = list.iterator();

		while (it.hasNext()) { // while(it.hasNext() == true)을 생략하여 사용
			Vehicle v4 = it.next();
			System.out.println(v4.getNum());
			System.out.println(v4.getColor());
			System.out.println(v4);
		}
		
		while(it.hasNext()){
			Vehicle v5 = it.next();
			System.out.println(v5);
			
		}

	}

}
