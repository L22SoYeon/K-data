package kdata.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {
	public static void main(String[] args) {

		List<Student> list = Arrays.asList(new Student(1, "이소연"), new Student(3, "김슬기"), new Student(2, "정송미"));

		System.out.println(list);

		
		// num 정렬
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getNum()-o2.getNum();
			}

		});
		
		System.out.println(list);
		
		// name 정렬
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}

		});

		System.out.println(list);
	}

}
