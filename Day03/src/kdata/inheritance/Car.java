package kdata.inheritance;

public class Car extends Vehicle {
	String name;
	// �⺻ ������
	/*Car(){
		super(); 
	}*/
	
	/*Car(int door){
		super(door); // ������ �ȿ��� ���� ù �ٿ� �����
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
