package kdata.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<>();

		list.add("������");
		list.add("������");
		list.add("�̼ҿ�");
		list.add("�ݿ���");

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

		Iterator<String> it = list.iterator(); // new�� ���� �ʴ� ���� : ��ü�� ��ȯ�ϱ� ������

		while (it.hasNext() == true) {
			/*String s = it.next();
			System.out.println(s);*/
			System.out.println(it.next());
		}

	}

}
