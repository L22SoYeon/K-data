package kdata.statictest;

public class Marine {

	// �ν��Ͻ� �ʵ� - ���� ����
	private int hp;

	// Ŭ���� �ʵ� - Ŭ���� �ε� �� �޼ҵ� ������ ����
	private static int level;

	// �ν��Ͻ� �޼ҵ�
	void setHp() {

	}

	// Ŭ���� �޼ҵ� (Ŭ���� �޼ҵ�� �ν��Ͻ� �ʵ忡 ���� �Ұ��� - static�� ���� ��������� ������)
	static void setLevel() {
		//this.level = 10; // ���� �Ұ���
		//hp = 100; // ���� �Ұ���
		level = 10;
	}
}
