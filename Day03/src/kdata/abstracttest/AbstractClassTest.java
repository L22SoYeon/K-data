package kdata.abstracttest;

public class AbstractClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Unit u = new Unit(); // 추상 클래스는 new 안됨
		
		Marine m = new Marine();
		m.move();
		
		Medic m2 = new Medic();
		m2.move();
		
		
	}

}
