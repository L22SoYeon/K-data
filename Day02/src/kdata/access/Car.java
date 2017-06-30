package kdata.access;

public class Car {

	// 접근 제어자
	private int num;
	private String color;
	private double cc;

	public Car(int num) {
		this.num = num;
	}

	void setNum(int num) {
		this.num = num;
	}

	int getNum() {
		return this.num;
	}

	void setColor(String color) {
		this.color = color;
	}

	String getColor() {
		return this.color;
	}

	void setCC(double cc) {
		this.cc = cc;
	}

	double getCC() {
		return this.cc;
	}
	
	public void test(){
		this.equals("");
	}
	
	public void test(int num){
		
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
}
