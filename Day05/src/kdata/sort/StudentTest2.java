package kdata.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentTest2 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student(1, "�̼ҿ�"), new Student(3, "�载��"), new Student(2, "���۹�"));

		Collections.sort(list);
		System.out.println(list);


	}

}
