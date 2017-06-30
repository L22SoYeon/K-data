package kdata.constructor;

public class Car {
	
	int num;
	String color;
	
	// 持失切
	Car(){
		System.out.println("Car() 持失切");
		this.num = 1;
		this.color = "black";
	}
	
	Car(String color){
		this.color = color;
	}
	
	Car(int num, String color){
		this.num = num;
		this.color = color;
	}
	
	Car(String color, int num){
		this.color = color;
		this.num = num;
	}
	
}
