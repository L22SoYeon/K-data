package kdata.interfacetest;

// 인터페이스
public interface Movable {

	// 상수 - 반드시 초기화
	int MAX_SPEED = 100;

	// 추상 메소드
	public abstract void main();
	
	default void move2(){
		
	}
}
