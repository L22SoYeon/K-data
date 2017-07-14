package kdata.manager;

public class Student {
	private String sId;
	private String sName;
	private String sex;

	public Student(String sId, String sName, String sex) {
		this.sId = sId;
		this.sName = sName;
		this.sex = sex;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "sId=" + sId + ", sName=" + sName + ", sex=" + sex;
	}

}
