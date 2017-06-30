package kdata.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentTest2 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student(1, "이소연"), new Student(3, "김슬기"), new Student(2, "정송미"));

		Collections.sort(list);
		System.out.println(list);


	}

}
