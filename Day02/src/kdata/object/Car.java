package kdata.object;

//Car Ŭ���� ����
public class Car {

	// �ʵ� ����
	int num;
	String color;

	// �޼ҵ� ����
	void print() {
		System.out.println("�ڵ��� Ŭ���� ���");
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
