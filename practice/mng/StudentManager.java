package practice.mng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	List<Student> starray = new ArrayList<>();

	public void add() {

		int num;
		String name;

		Scanner n = new Scanner(System.in);

		System.out.print("�̸��� �Է��ϼ��� : ");
		name = n.next();
		System.out.print("��ȣ�� �Է��ϼ��� : ");
		num = n.nextInt();

		starray.add(new Student(name, num));
	}

	public void print() {

		for(Student s:starray) {
			System.out.println(s);
		}

	}
	
	public void exit() {
		System.exit(0);
	}
}
