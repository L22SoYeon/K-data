package kdata.anonymous;

public class AnonymouseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Movable() { // 객체 이름 없음 - 한 번만 사용 가능

			@Override
			public void move() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous");
			}

		}.move();

		Movable m = new Movable() {

			@Override
			public void move() {
				// TODO Auto-generated method stub

			}

		};

		Movable m2 = () -> System.out.println("Lamda");

	}

}
