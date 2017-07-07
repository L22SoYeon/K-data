package kdata.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ManagerTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentManager sm = new StudentManager();
		CourseManager cm = new CourseManager();

		String sId;
		String sName;
		String sex;
		String sjId;
		// int grade;
		// Date cDay;

		int result = 0;

		while (true) {
			System.out.println("1. �л� ���� �߰�");
			System.out.println("2. �л� ���� ���");
			System.out.println("3. �л� �˻�");
			System.out.println("4. ���� ��û");
			System.out.println("5. ���� ���");
			System.out.println("6. ���� ��û ���");
			System.out.println("7. ���� �Է�");
			System.out.println("------------------------");

			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.println("�й��� �Է��� �ּ��� : ");
				sId = sc.next();
				System.out.println("�̸��� �Է��� �ּ��� : ");
				sName = sc.next();
				System.out.println("������ �Է��� �ּ��� : ");
				sex = sc.next();

				if (sId.equals(null)) {
					System.out.println("�й��� �ٽ� �Է��� �ּ���");
				} else if (sId.length() != 8) {
					System.out.println("�й��� 8�ڸ��� �ٽ� �Է��� �ּ���");

				} else {
					Student s = new Student(sId, sName, sex);

					try {
						result = sm.insert(s);

					} catch (SQLException e) {
						e.printStackTrace();
					}

					if (result == 0)
						System.out.println("����");
					else
						System.out.println("����");

				}
				break;
			case 2:
				try {
					List<Student> list = sm.selectAll();

					for (Student s : list) {
						System.out.println(s.getsId() + "\t" + s.getsName() + "\t" + s.getSex());
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("�˻��� �̸��� �Է��� �ּ��� : ");
				sc.nextLine();
				sName = sc.nextLine();
				Student s = sm.selectByName(sName);

				System.out.println(s.toString());
			case 4:
				System.out.println("�й��� �Է��� �ּ��� : ");
				sId = sc.next();
				System.out.println("���� ��ȣ�� �Է��� �ּ��� : ");
				sjId = sc.next();

				Course c = new Course(sId, sjId);
				result = cm.courseInsert(c);

				if (result == 0)
					System.out.println("������û ����");
				else
					System.out.println("������û ����");
				break;
			case 5:
				System.out.println("�й��� �Է��� �ּ��� : ");
				sId = sc.next();
				System.out.println("����� ���� ��ȣ�� �Է��� �ּ��� : ");
				sjId = sc.next();

				Course c2 = new Course(sId, sjId);
				result = cm.courseDelete(c2);

				if (result == 0)
					System.out.println("������� ����");
				else
					System.out.println("������� ����");
				break;
			case 6:
				cm.courseList();
				break;
			case 7:
				break;
			}

		}
	}
}
/*
 * ������û ����Ʈ - 3�� ���� �����Է�
 * 
 * �����Ŵ���Ŭ����, ����Ŭ����, java doc����
 * 
 */
