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

		System.out.print("이름을 입력하세요 : ");
		name = n.next();
		System.out.print("번호를 입력하세요 : ");
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
