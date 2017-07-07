package kdata.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ManagerTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentManager sm = new StudentManager();
		CourseManager cm = new CourseManager();

		String sId;
		String sName;
		String sex;
		String sjId;
		// int grade;
		// Date cDay;

		int result = 0;

		while (true) {
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 출력");
			System.out.println("3. 학생 검색");
			System.out.println("4. 수강 신청");
			System.out.println("5. 수강 취소");
			System.out.println("6. 수강 신청 목록");
			System.out.println("7. 성적 입력");
			System.out.println("------------------------");

			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.println("학번을 입력해 주세요 : ");
				sId = sc.next();
				System.out.println("이름을 입력해 주세요 : ");
				sName = sc.next();
				System.out.println("성별을 입력해 주세요 : ");
				sex = sc.next();

				if (sId.equals(null)) {
					System.out.println("학번을 다시 입력해 주세요");
				} else if (sId.length() != 8) {
					System.out.println("학번을 8자리로 다시 입력해 주세요");

				} else {
					Student s = new Student(sId, sName, sex);

					try {
						result = sm.insert(s);

					} catch (SQLException e) {
						e.printStackTrace();
					}

					if (result == 0)
						System.out.println("실패");
					else
						System.out.println("성공");

				}
				break;
			case 2:
				try {
					List<Student> list = sm.selectAll();

					for (Student s : list) {
						System.out.println(s.getsId() + "\t" + s.getsName() + "\t" + s.getSex());
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("검색할 이름을 입력해 주세요 : ");
				sc.nextLine();
				sName = sc.nextLine();
				Student s = sm.selectByName(sName);

				System.out.println(s.toString());
			case 4:
				System.out.println("학번을 입력해 주세요 : ");
				sId = sc.next();
				System.out.println("과목 번호를 입력해 주세요 : ");
				sjId = sc.next();

				Course c = new Course(sId, sjId);
				result = cm.courseInsert(c);

				if (result == 0)
					System.out.println("수강신청 실패");
				else
					System.out.println("수강신청 성공");
				break;
			case 5:
				System.out.println("학번을 입력해 주세요 : ");
				sId = sc.next();
				System.out.println("취소할 과목 번호를 입력해 주세요 : ");
				sjId = sc.next();

				Course c2 = new Course(sId, sjId);
				result = cm.courseDelete(c2);

				if (result == 0)
					System.out.println("수강취소 실패");
				else
					System.out.println("수강취소 성공");
				break;
			case 6:
				cm.courseList();
				break;
			case 7:
				break;
			}

		}
	}
}
/*
 * 수강신청 리스트 - 3개 조인 성적입력
 * 
 * 수강매니저클래스, 수강클래스, java doc까지
 * 
 */
