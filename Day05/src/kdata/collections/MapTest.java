package kdata.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> map = new HashMap<>();

		map.put(10, "A");
		map.put(20, "B");
		map.put(30, "c");

		System.out.println(map);

		System.out.println(map.get(10));

		Set<Integer> keySet = map.keySet();

		System.out.println("");
		// 키만 꺼내기
		for (int i : keySet)
			System.out.println(i);

		System.out.println("");
		// 값만 꺼내기
		for (int i : keySet)
			System.out.println(map.get(i));

		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

		System.out.println("");
		// 둘 다 꺼내기
		for (Map.Entry<Integer, String> entry : entrySet) {
			System.out.print(entry.getKey());
			System.out.println(entry.getValue());
		}

		System.out.println("");
		// iterator로 꺼내기
		Iterator<Entry<Integer, String>> it = entrySet.iterator();

		while (it.hasNext()) {
			Entry<Integer, String> e = it.next();
			System.out.print(e.getKey());
			System.out.println(e.getValue());
		}
		
		/*Set<Integer> keySet = map.keySet();
		keySet.iterator();
		
		map.keySet().iterator();*/ //위 두줄과 이 한줄은 같은 코드
		

	}

}
