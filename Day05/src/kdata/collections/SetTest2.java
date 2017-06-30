package kdata.collections;

import java.util.HashSet;
import java.util.Set;

public class SetTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Vehicle> set = new HashSet<>();

		set.add(new Vehicle(1, "red"));
		set.add(new Vehicle(1, "red"));
		set.add(new Vehicle(3, "yellow"));

		
		System.out.println(set); //해시코드로 비교하는데 해시코드가 다르므로 다 출력
	}

}
