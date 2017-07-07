import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	static private List<Student> starray;

	public StudentManager() {
		if (starray == null) {
			starray = new ArrayList<>();
		}
	}

	Scanner n = new Scanner(System.in);

	public void add() {

		int num;
		String name;
		String address;
		int phone;
		int kor;
		int eng;
		int math;

		System.out.println("번호를 입력하세요 : ");
		num = n.nextInt();
		System.out.println("이름을 입력하세요 : ");
		name = n.next();
		System.out.println("주소를 입력하세요 : ");
		address = n.next();
		n.nextLine();
		System.out.println("핸드폰 번호를 입력하세요 : ");
		phone = n.nextInt();
		System.out.println("국어 점수를 입력하세요 : ");
		kor = n.nextInt();
		System.out.println("영어 점수를 입력하세요 : ");
		eng = n.nextInt();
		System.out.println("수학 점수를 입력하세요 : ");
		math = n.nextInt();

		starray.add(new Student(num, name, address, phone, kor, eng, math));
	}

	public void print() {
		System.out.println("번호        이름        주소        핸번        국어        영어        수학");
		Collections.sort(starray);
		for (Student s : starray) 
			System.out.println(s);
	}

	public void search() {
		String sname;

		System.out.println("검색할 데이터를 입력하세요 : ");
		sname = n.next();

		for (Student s : starray) {
			if (s.getName().equals(sname)) {
				System.out.println("이름 : " + s.getName());
				System.out.println("번호 : " + s.getNum());
				System.out.println("주소 : " + s.getAddress());
				System.out.println("핸번 : " + s.getPhone());
				System.out.println("국어 점수 : " + s.getKor());
				System.out.println("영어 점수 : " + s.getEng());
				System.out.println("수학 점수 : " + s.getMath());
				System.out.println("총합 : " + s.getTotal());
			}
		}
	}

	public void remove() {
		String rname;
		
		System.out.println("삭제할 데이터를 입력하세요 : ");
		rname = n.next();
		
		for(Iterator<Student> iterator = starray.iterator(); iterator.hasNext();){
			Student s = iterator.next();
			if(s.getName().equals(rname))
			{
				iterator.remove();
			}
		}
	}

	public void sum(){
		int totalsum = 0;
		System.out.print("총점 : ");
	
		for (Student s : starray) 
			totalsum += s.getTotal();
			System.out.println(totalsum);
	}
	
	public void max(){
		int max = 0;
		System.out.println();
	}
	
	public void minimum(){
		
	}
	
	
	public void exit() {
		System.exit(0);
	}
}