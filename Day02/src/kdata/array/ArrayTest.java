package kdata.array;

public class ArrayTest {

	public static void main(String[] args) {

		int[] ar; // ���ÿ� ����

		ar = new int[5]; // ���� ����

		ar[0] = 10;
		ar[1] = 20;
		ar[2] = 30;
		ar[3] = 40;
		ar[4] = 50;

		System.out.println(ar[0]);
		System.out.println(ar.length);

		System.out.println(" ");
		
		for (int i = 0; i < ar.length; i++) {
			System.out.println("ar[" + i + "]" + " = " + ar[i]);
		}

			int[] vr; // ���ÿ� ����

			vr = new int[]{11, 22, 33, 44, 55}; // ���� ����




			for (int i = 0; i < vr.length; i++) {
				System.out.println("ar[" + i + "]" + " = " + vr[i]);
			}

	}

}
