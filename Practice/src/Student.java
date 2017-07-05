public class Student implements Comparable<Student> {

	private int num;
	private String name;
	private String address;
	private int phone;

	public Student(int num, String name, String address, int phone) {
		super();
		this.num = num;
		this.name = name;
		this.address = address;
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.name.compareTo(o.name);
	}

}