package kdata.manager;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ManagerTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentManager sm = new StudentManager();
		CourseManager cm = new CourseManager();

		String sId;
		String sName;
		String sex;
		String sjId;
		int grade;

		int result = 0;

		while (true) {
			System.out.println("1. �л� ���� �߰�");
			System.out.println("2. �л� ���� ���");
			System.out.println("3. �л� ���� �˻�");
			System.out.println("4. ���� ��û");
			System.out.println("5. ���� ���");
			System.out.println("6. ���� ��û ���");
			System.out.println("7. ���� �Է�");
			System.out.println("8. ���� ���");
			System.out.println("------------------------");

			int select = sc.nextInt();

			switch (select) {
			case 1: // �л� ���� �߰�
				System.out.println("�й� �Է� : ");
				sId = sc.next();
				System.out.println("�̸� �Է� : ");
				sName = sc.next();
				System.out.println("���� �Է� : ");
				sex = sc.next();

				// ---------- ��ȿ�� �˻�
				if (sId.equals(null) || sName.equals(null) || sex.equals(null)) {
					System.out.println("�ٽ� �Է��� �ּ���");
				} else if (sId.length() != 8) {
					System.out.println("�й��� 8�ڸ��� �ٽ� �Է��� �ּ���");
				} else {
					Student s = new Student(sId, sName, sex);

					result = sm.insert(s);

					if (result == 0)
						System.out.println("�߰� ����");
					else
						System.out.println("�߰� ����");
				}
				break;
			case 2: // �л� ���� ���
				List<Student> list = sm.selectAll();

				for (Student s : list) {
					System.out.println(s.getsId() + "\t" + s.getsName() + "\t" + s.getSex());
				}
				break;
			case 3: // �л� ���� �˻�
				System.out.println("�̸� �Է� : ");
				sc.nextLine();

				sName = sc.nextLine();
				Student s = sm.selectByName(sName);

				System.out.println(s.toString());
				break;
			case 4: // ���� ��û
				System.out.println("�й� �Է� : ");
				sId = sc.next();
				System.out.println("�����ȣ �Է� : ");
				sjId = sc.next();

				Course c = new Course(sId, sjId);
				result = cm.courseInsert(c);

				if (result == 0)
					System.out.println("������û ����");
				else
					System.out.println("������û ����");
				break;
			case 5: // ���� ��û ���
				System.out.println("�й� �Է� : ");
				sId = sc.next();
				System.out.println("�����ȣ �Է� : ");
				sjId = sc.next();

				Course c2 = new Course(sId, sjId);
				result = cm.courseDelete(c2);

				if (result == 0)
					System.out.println("������� ����");
				else
					System.out.println("������� ����");
				break;
			case 6: // ���� ��û ���
				cm.courseList();
				break;
			case 7: // ���� �Է�
				System.out.println("�й� �Է� : ");
				sId = sc.next();
				System.out.println("�����ȣ �Է� : ");
				sjId = sc.next();
				System.out.println("���� �Է� : ");
				grade = sc.nextInt();

				Course c3 = new Course(sId, sjId, grade);
				result = cm.courseScoreInsert(c3);

				if (result == 0)
					System.out.println("�����Է� ����");
				else
					System.out.println("�����Է� ����");

				break;
			case 8: // ���� ���
				Map<String, Integer> map = cm.courseAverage();

				Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

				for (Map.Entry<String, Integer> entry : entrySet) {
					System.out.println(entry.getKey() + "\t" + entry.getValue());
				}
				break;

			}

		}
	}
}
