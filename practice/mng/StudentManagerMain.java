package practice.mng;

import java.util.Scanner;

public class StudentManagerMain extends StudentManager {

	public static void main(String[] args) {

		// �л� ���� �Լ� ȣ��
		while (true) {

			// ����
			System.out.println("-----�л�����-----");
			System.out.println("1. �л� ���� �߰�");
			System.out.println("2. �л� ����Ʈ");
			System.out.println("3. ����");
			System.out.println("----------------");

			// ��ȣ �Է� �ޱ�
			Scanner sc = new Scanner(System.in);
			int select = sc.nextInt();

			StudentManager sm = new StudentManager();

			// ��� ����
			switch (select) {
			case 1:
				System.out.println("1. �л� ���� �߰�");
				sm.add();
				break;
			case 2:
				System.out.println("2. �л� ����Ʈ");
				sm.print();
				break;
			case 3:
				System.out.println("-----�����մϴ�-----");
				sm.exit();
				break;

			}
		}

	}

}
