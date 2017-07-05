import java.util.Scanner;

public class StudentManagerMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 학생 관리 함수 호출
		while (true) {

			// 메인
			System.out.println("-----학생관리-----");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 리스트");
			System.out.println("3. 검색");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			System.out.println("----------------");

			// 번호 입력 받기

			int select = sc.nextInt();

			StudentManager sm = new StudentManager();

			// 기능 선택
			switch (select) {
			case 1:
				//System.out.println("1. 학생 정보 추가");
				sm.add();
				break;
			case 2:
				//System.out.println("2. 학생 리스트");
				sm.print();
				break;
			case 3:
				//System.out.println("3. 검색");
				sm.search();
				break;
			case 4:
				//System.out.println("4. 삭제");
				sm.remove();
				break;
			case 5:
				System.out.println("-----종료합니다-----");
				sc.close();
				sm.exit();
				break;

			}
		}

	}

}