package kdata.inheritance;

public class Car extends Vehicle {
	String name;
	// 기본 생성자
	/*Car(){
		super(); 
	}*/
	
	/*Car(int door){
		super(door); // 생성자 안에서 가장 첫 줄에 써야함
	}*/

	/*Car(){
		super(1);
		System.out.println("Car()");
	}*/
	
	@Override
	void move(){
		super.move();
		System.out.println("Car move()");
	}
}
