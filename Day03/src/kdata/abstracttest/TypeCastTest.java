package kdata.abstracttest;

public class TypeCastTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 형변환 테스트
		// instanceof 테스트

		Marine m = new Marine();

		System.out.println(m instanceof Marine); // 형변환 가능 여부 확인
		//System.out.println(m instanceof Medic);
		System.out.println(m instanceof Unit); // 자식에서 부모로 형변환은 자동으로 되나
		System.out.println(m instanceof Object); //부모에서 자식으로의 형변환은 instanceof로 확인해보기

		// 자동 형변환 => 형변환 연산자 생략 가능
		Unit u = new Marine();  
		u.move();
		
		Unit u2 = new Medic();
		u2.move();
		
		System.out.println(u instanceof Unit);
		System.out.println(u instanceof Marine);
		
		// 강제 형변환 => 형변환 연산자 생략 불가
		Marine m3 = (Marine) u;
		
		
		Object o = new Marine();
		Object o2 = new Object();
		
		System.out.println(o instanceof Object);
		System.out.println(o instanceof Marine);
		System.out.println(o2 instanceof Marine);
	}

}
