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
			System.out.println("5. 전체 총점");
			System.out.println("6. 최고 점수");
			System.out.println("7. 최저 점수");
			System.out.println("8. 종료");
			//System.out.println("전체총점-모든학생의 총점
			//, 회고점수, 최저점수"); 추가하기
			/*
			 * 학생 리스트 출력
			 * 학번 이름 주소 전화번호 국어 영어 수학 총점 평균
			 * 
			 * 리스트 출력 빼고는 다 메인에서 출력하기
			 * 
			 * 
			 * 
			 * 검색결과가 있으면 void가 아닌 int로 반환
			 * 
			*/
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
				sm.sum();
				break;
			case 6:
				sm.max();
				break;
			case 7:
				sm.minimum();
				break;
			case 8:
				System.out.println("-----종료합니다-----");
				sc.close();
				sm.exit();
				break;

			}
		}

	}

}