package kdata.student;

import java.util.Scanner;

public class StudentManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. 학생 정보 추가
		// 2. 학생 리스트 출력
		// 3. 학생 이름 검색

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 리스트 출력");
			System.out.println("3. 학생 이름 검색");
			System.out.println("4. 종료");
			System.out.println("------------------------");

			int select = sc.nextInt();

			StudentManager sm = new StudentManager();
			
			switch (select) {
			case 1:
				String s_id;
				String s_name;
				String s_sex;

				System.out.println("학번을 입력해 주세요 : ");
				s_id = sc.next();
				System.out.println("이름을 입력해 주세요 : ");
				s_name = sc.next();
				System.out.println("성별을 입력해 주세요 : ");
				s_sex = sc.next();
				
				sm.add(new Student(s_id, s_name, s_sex));
				break;
			case 2:
				sm.print();
				break;
			case 3:
				sm.search();
				break;

			}

		}
	}

}
