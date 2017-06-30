package kdata.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kdata.collections.MyComparator;

public class SortTest {

	public static void main(String[] args) {


		List<Integer> list = Arrays.asList(5, 3, 10, 1, 2); // ����

		// �迭 ���
		System.out.println(list);

		/*
		 * // �迭 ���� Collections.sort(list);
		 * 
		 * // ���ĵ� �迭 ��� System.out.println(list);
		 */
		
		// Collections.sort(list, new MyComparator());
		
		Collections.sort(list, new Comparator<Integer>(){
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0 - arg1;
			}
		});
		System.out.println(list);
	}

}
