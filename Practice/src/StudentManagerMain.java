import java.util.Scanner;

public class StudentManagerMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �л� ���� �Լ� ȣ��
		while (true) {

			// ����
			System.out.println("-----�л�����-----");
			System.out.println("1. �л� ���� �߰�");
			System.out.println("2. �л� ����Ʈ");
			System.out.println("3. �˻�");
			System.out.println("4. ����");
			System.out.println("5. ����");
			System.out.println("----------------");

			// ��ȣ �Է� �ޱ�

			int select = sc.nextInt();

			StudentManager sm = new StudentManager();

			// ��� ����
			switch (select) {
			case 1:
				//System.out.println("1. �л� ���� �߰�");
				sm.add();
				break;
			case 2:
				//System.out.println("2. �л� ����Ʈ");
				sm.print();
				break;
			case 3:
				//System.out.println("3. �˻�");
				sm.search();
				break;
			case 4:
				//System.out.println("4. ����");
				sm.remove();
				break;
			case 5:
				System.out.println("-----�����մϴ�-----");
				sc.close();
				sm.exit();
				break;

			}
		}

	}

}