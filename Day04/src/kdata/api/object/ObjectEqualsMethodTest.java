package kdata.api.object;

public class ObjectEqualsMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = o1;

		System.out.println(o1 == o2);
		System.out.println(o1 == o3);
		
		System.out.println(o1.equals(o2));
		System.out.println(o1.equals(o3));
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		System.out.println(s1==s2); // 주소가 달라서
		System.out.println(s1.equals(s2)); // String 클래스에서  overriding됬음
		
		Car c1 = new Car(1, "RED");
		Car c2 = new Car(1, "RED");
		
		System.out.println(c1==c2);
		System.out.println(c1.equals(c2));
	}

}
