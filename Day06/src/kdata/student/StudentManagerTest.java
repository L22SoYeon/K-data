package kdata.student;

import java.util.Scanner;

public class StudentManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. �л� ���� �߰�
		// 2. �л� ����Ʈ ���
		// 3. �л� �̸� �˻�

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. �л� ���� �߰�");
			System.out.println("2. �л� ����Ʈ ���");
			System.out.println("3. �л� �̸� �˻�");
			System.out.println("4. ����");
			System.out.println("------------------------");

			int select = sc.nextInt();

			StudentManager sm = new StudentManager();
			
			switch (select) {
			case 1:
				String s_id;
				String s_name;
				String s_sex;

				System.out.println("�й��� �Է��� �ּ��� : ");
				s_id = sc.next();
				System.out.println("�̸��� �Է��� �ּ��� : ");
				s_name = sc.next();
				System.out.println("������ �Է��� �ּ��� : ");
				s_sex = sc.next();
				
				sm.add(new Student(s_id, s_name, s_sex));
				break;
			case 2:
				sm.print();
				break;
			case 3:
				sm.search();
				break;

			}

		}
	}

}
