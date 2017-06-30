package kdata.constructor;

public class CarTest {

	public static void main(String[] args) {
		
		Car c = new Car();
		System.out.println(c.num);
		System.out.println(c.color);
		
		Car c2 = new Car("pink");
		System.out.println(c2.color);
		
		Car c3 = new Car(3, "yellow");
		System.out.println(c3.num);
		System.out.println(c3.color);
		
		Car c4 = new Car(4, "gray");
		System.out.println(c4.color);
		System.out.println(c4.num);
	}

}
