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

		
		System.out.println(set); //�ؽ��ڵ�� ���ϴµ� �ؽ��ڵ尡 �ٸ��Ƿ� �� ���
	}

}
