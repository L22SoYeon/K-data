import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	static private List<Student> starray;

	public StudentManager() {
		if (starray == null) {
			starray = new ArrayList<>();
		}
	}

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
		System.out.println("��ȣ        �̸�");
		Collections.sort(starray);
		for (Student s : starray) {
			System.out.println(s);
		}

	}

	/*
	 * public void search(){ if() }
	 */
	
	public void exit() {
		System.exit(0);
	}
}