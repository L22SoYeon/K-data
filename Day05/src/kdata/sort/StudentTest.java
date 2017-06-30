package kdata.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {
	public static void main(String[] args) {

		List<Student> list = Arrays.asList(new Student(1, "�̼ҿ�"), new Student(3, "�载��"), new Student(2, "���۹�"));

		System.out.println(list);

		
		// num ����
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getNum()-o2.getNum();
			}

		});
		
		System.out.println(list);
		
		// name ����
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}

		});

		System.out.println(list);
	}

}
