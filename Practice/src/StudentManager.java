import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	static private List<Student> starray;

	public StudentManager() {
		if (starray == null) {
			starray = new ArrayList<>();
		}
	}

	Scanner n = new Scanner(System.in);

	public void add() {

		int num;
		String name;
		String address;
		int phone;


		System.out.println("��ȣ�� �Է��ϼ��� : ");
		num = n.nextInt();
		System.out.println("�̸��� �Է��ϼ��� : ");
		name = n.next();
		System.out.println("�ּҸ� �Է��ϼ��� : ");
		address = n.next();
		System.out.println("�ڵ��� ��ȣ�� �Է��ϼ��� : ");
		phone = n.nextInt();


		starray.add(new Student(num, name, address, phone));
	}

	public void print() {
		System.out.println("��ȣ        �̸�        �ּ�        �ڹ�");
		Collections.sort(starray);
		for (Student s : starray) 
			System.out.println(s);
	}

	public void search() {
		String sname;

		System.out.println("�˻��� �����͸� �Է��ϼ��� : ");
		sname = n.next();

		for (Student s : starray) {
			if (s.getName().equals(sname)) {
				System.out.println("�̸� : " + s.getName());
				System.out.println("��ȣ : " + s.getNum());
				System.out.println("�ּ� : " + s.getAddress());
				System.out.println("�ڹ� : " + s.getPhone());
			}
		}
	}

	public void remove() {
		String rname;
		
		System.out.println("������ �����͸� �Է��ϼ��� : ");
		rname = n.next();
		
		for(Iterator<Student> iterator = starray.iterator(); iterator.hasNext();){
			Student s = iterator.next();
			if(s.getName().equals(rname))
			{
				iterator.remove();
			}
		}
		
		/*for (Student s : starray) {
			if (s.getName().equals(rname)) {
				starray.remove(0);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			}
		}*/
	}

	public void exit() {
		System.exit(0);
	}
}