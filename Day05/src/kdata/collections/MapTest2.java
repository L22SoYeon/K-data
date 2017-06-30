package kdata.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Vehicle, String> map = new HashMap<>();

		map.put(new Vehicle(1, "red"), "bmw");
		map.put(new Vehicle(1, "red"), "benz");
		map.put(new Vehicle(4, "yello"), "samsung");
		
		System.out.println(map);
	}

}
