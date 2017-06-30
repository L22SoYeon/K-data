package kdata.abstracttest;

// 추상 클래스 (일반 메소드, 추상 메소드 둘 다 가능)
public abstract class Unit {
	
	// 생성자
	Unit() {
		System.out.println("Unit()");
	}

	// 일반 메소드
	void run() {

	}

	// 추상 메소드
	abstract void move();

	  
}
