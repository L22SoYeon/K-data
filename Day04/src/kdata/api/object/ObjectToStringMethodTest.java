package kdata.api.object;

public class ObjectToStringMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o = new Object();
		System.out.println(o.toString());
		System.out.println(o);

		Object o2 = new Object();
		System.out.println(o2.toString());
		System.out.println(o2);
		
		Car c = new Car();
		System.out.println(c.toString());
		System.out.println(c);
		
		System.out.println(o.getClass());
		System.out.println(c.getClass());
		System.out.println(c.hashCode());
		System.out.println(c.getClass().getName());
		
		String s = new String("Hello");
		System.out.println(s.toString());
		System.out.println(s); // String 클래스에서 toString 클래스를 오버라이딩해서
		
		Car c2 = new Car(1,"RED");
		System.out.println(c2.toString());
		System.out.println(c2);
		
	}

}
