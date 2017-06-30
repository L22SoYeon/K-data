package kdata.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<>();

		list.add("정다은");
		list.add("김현태");
		list.add("이소연");
		list.add("금원필");

		System.out.println(list);

		System.out.println("");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("");

		for (String s : list) {
			System.out.println(s);
		}

		System.out.println("");

		Iterator<String> it = list.iterator(); // new를 쓰지 않는 이유 : 객체를 반환하기 때문에

		while (it.hasNext() == true) {
			/*String s = it.next();
			System.out.println(s);*/
			System.out.println(it.next());
		}

	}

}
