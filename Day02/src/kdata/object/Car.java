package kdata.object;

//Car 클래스 정의
public class Car {

	// 필드 선언
	int num;
	String color;

	// 메소드 정의
	void print() {
		System.out.println("자동차 클래스 출력");
		System.out.println(this.num);
		System.out.println(this.color);
	}

	void setColor(String color) {
		this.color = color;
	}
	
	String getColor(){
		return this.color;
	}
	
	void setNum(int num){
		this.num = num;
	}
	
	int getNum(){
		return this.num;
	}
}
