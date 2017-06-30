package kdata.api.object;

public class WrapperClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10;

		Integer i2 = new Integer(i);
		i2.intValue();
		Integer i3 = 10;

		String s1 = "10";
		String s2 = "20";
		System.out.println(s1 + s2);

		int a1 = Integer.parseInt(s1);
		int a2 = Integer.parseInt(s2);

		System.out.println(a1 + a2);
		System.out.println(Integer.parseInt(s1)+Integer.parseInt(s2));
		
		Double.parseDouble(s1);
	}

}
