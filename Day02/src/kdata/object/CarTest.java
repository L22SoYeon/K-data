package kdata.object;

import java.lang.String; // �길 ��������

public class CarTest {

	public static void main(String[] args) {

		// ���� ����
		Car c; // ���ÿ� ����(�ּҰ� �� ����)

		c = new Car();

		c.num = 1;
		c.color = "Red"; // c.color = new String(); �� ����ϳ� �޸� ������ �ٸ��� ����
		System.out.println(c.color);
		c.print(); // �޼��� ȣ��

		c.setColor("Black");
		System.out.println(c.num);
		System.out.println(c.color);

		System.out.println(" ");

		// c2
		Car c2 = new Car();

		c2.num = 2;
		c2.color = "Blue";
		c2.print();

		System.out.println(c2.num);
		System.out.println(c2.color);

		System.out.println(" ");

		// c3
		Car c3 = new Car();
		c3.num = 3;
		c3.color = "Pink";
		System.out.println(c3.num);
		c3.setColor("Blue");
		String s = c3.getColor();
		System.out.println(s);
	}

}
