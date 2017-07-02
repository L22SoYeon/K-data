package practice.mng;

import java.util.Scanner;

public class StudentManagerMain extends StudentManager {

	public static void main(String[] args) {

		// 학생 관리 함수 호출
		while (true) {

			// 메인
			System.out.println("-----학생관리-----");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 리스트");
			System.out.println("3. 종료");
			System.out.println("----------------");

			// 번호 입력 받기
			Scanner sc = new Scanner(System.in);
			int select = sc.nextInt();

			StudentManager sm = new StudentManager();

			// 기능 선택
			switch (select) {
			case 1:
				System.out.println("1. 학생 정보 추가");
				sm.add();
				break;
			case 2:
				System.out.println("2. 학생 리스트");
				sm.print();
				break;
			case 3:
				System.out.println("-----종료합니다-----");
				sm.exit();
				break;

			}
		}

	}

}
