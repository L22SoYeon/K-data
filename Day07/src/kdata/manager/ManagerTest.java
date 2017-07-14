package kdata.manager;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ManagerTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentManager sm = new StudentManager();
		CourseManager cm = new CourseManager();

		String sId;
		String sName;
		String sex;
		String sjId;
		int grade;

		int result = 0;

		while (true) {
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 출력");
			System.out.println("3. 학생 정보 검색");
			System.out.println("4. 수강 신청");
			System.out.println("5. 수강 취소");
			System.out.println("6. 수강 신청 목록");
			System.out.println("7. 성적 입력");
			System.out.println("8. 과목 평균");
			System.out.println("------------------------");

			int select = sc.nextInt();

			switch (select) {
			case 1: // 학생 정보 추가
				System.out.println("학번 입력 : ");
				sId = sc.next();
				System.out.println("이름 입력 : ");
				sName = sc.next();
				System.out.println("성별 입력 : ");
				sex = sc.next();

				// ---------- 유효성 검사
				if (sId.equals(null) || sName.equals(null) || sex.equals(null)) {
					System.out.println("다시 입력해 주세요");
				} else if (sId.length() != 8) {
					System.out.println("학번을 8자리로 다시 입력해 주세요");
				} else {
					Student s = new Student(sId, sName, sex);

					result = sm.insert(s);

					if (result == 0)
						System.out.println("추가 실패");
					else
						System.out.println("추가 성공");
				}
				break;
			case 2: // 학생 정보 출력
				List<Student> list = sm.selectAll();

				for (Student s : list) {
					System.out.println(s.getsId() + "\t" + s.getsName() + "\t" + s.getSex());
				}
				break;
			case 3: // 학생 정보 검색
				System.out.println("이름 입력 : ");
				sc.nextLine();

				sName = sc.nextLine();
				Student s = sm.selectByName(sName);

				System.out.println(s.toString());
				break;
			case 4: // 수강 신청
				System.out.println("학번 입력 : ");
				sId = sc.next();
				System.out.println("과목번호 입력 : ");
				sjId = sc.next();

				Course c = new Course(sId, sjId);
				result = cm.courseInsert(c);

				if (result == 0)
					System.out.println("수강신청 실패");
				else
					System.out.println("수강신청 성공");
				break;
			case 5: // 수강 신청 취소
				System.out.println("학번 입력 : ");
				sId = sc.next();
				System.out.println("과목번호 입력 : ");
				sjId = sc.next();

				Course c2 = new Course(sId, sjId);
				result = cm.courseDelete(c2);

				if (result == 0)
					System.out.println("수강취소 실패");
				else
					System.out.println("수강취소 성공");
				break;
			case 6: // 수강 신청 목록
				cm.courseList();
				break;
			case 7: // 성적 입력
				System.out.println("학번 입력 : ");
				sId = sc.next();
				System.out.println("과목번호 입력 : ");
				sjId = sc.next();
				System.out.println("점수 입력 : ");
				grade = sc.nextInt();

				Course c3 = new Course(sId, sjId, grade);
				result = cm.courseScoreInsert(c3);

				if (result == 0)
					System.out.println("점수입력 실패");
				else
					System.out.println("점수입력 성공");

				break;
			case 8: // 과목 평균
				Map<String, Integer> map = cm.courseAverage();

				Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

				for (Map.Entry<String, Integer> entry : entrySet) {
					System.out.println(entry.getKey() + "\t" + entry.getValue());
				}
				break;

			}

		}
	}
}
