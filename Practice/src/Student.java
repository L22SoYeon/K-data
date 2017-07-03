public class Student implements Comparable<Student> {

	private int num;
	private String name;

	public Student(String name, int num) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return num + "     " + name;
	}

	@Override
	public int compareTo(Student o) {
		return this.name.compareTo(o.name);
	}

}