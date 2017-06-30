package kdata.statictest;

public class Marine {

	// 인스턴스 필드 - 힙에 생성
	private int hp;

	// 클래스 필드 - 클래스 로드 시 메소드 영역에 생성
	private static int level;

	// 인스턴스 메소드
	void setHp() {

	}

	// 클래스 메소드 (클래스 메소드는 인스턴스 필드에 접근 불가능 - static이 먼저 만들어지기 때문에)
	static void setLevel() {
		//this.level = 10; // 접근 불가능
		//hp = 100; // 접근 불가능
		level = 10;
	}
}
