package kdata.abstracttest;

public class TypeCastTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ����ȯ �׽�Ʈ
		// instanceof �׽�Ʈ

		Marine m = new Marine();

		System.out.println(m instanceof Marine); // ����ȯ ���� ���� Ȯ��
		//System.out.println(m instanceof Medic);
		System.out.println(m instanceof Unit); // �ڽĿ��� �θ�� ����ȯ�� �ڵ����� �ǳ�
		System.out.println(m instanceof Object); //�θ𿡼� �ڽ������� ����ȯ�� instanceof�� Ȯ���غ���

		// �ڵ� ����ȯ => ����ȯ ������ ���� ����
		Unit u = new Marine();  
		u.move();
		
		Unit u2 = new Medic();
		u2.move();
		
		System.out.println(u instanceof Unit);
		System.out.println(u instanceof Marine);
		
		// ���� ����ȯ => ����ȯ ������ ���� �Ұ�
		Marine m3 = (Marine) u;
		
		
		Object o = new Marine();
		Object o2 = new Object();
		
		System.out.println(o instanceof Object);
		System.out.println(o instanceof Marine);
		System.out.println(o2 instanceof Marine);
	}

}
