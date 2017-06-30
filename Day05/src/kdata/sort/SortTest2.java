package kdata.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest2 {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("정다은", "김현태", "금원필");

		System.out.println(list);

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		System.out.println(list);
	}

}
