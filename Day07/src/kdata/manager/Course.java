package kdata.manager;

import java.sql.Date;

public class Course {
	private String sId;
	private String sjId;
	private String sName;
	private String sjName;
	private int grade;
	private Date cDay;

	public Course(String sId, String sjId) {
		super();
		this.sId = sId;
		this.sjId = sjId;
	}
	
	public Course(String sjName, int grade){
		super();
		this.sjName = sjName;
		this.grade = grade;
	}

	public Course(String sId, String sName, String sjName, int grade, Date cDay) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sjId = sjName;
		this.grade = grade;
		this.cDay = cDay;
	}

	public Course(String sId, String sjId, int grade) {
		super();
		this.sId = sId;
		this.sjId = sjId;
		this.grade = grade;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getSjId() {
		return sjId;
	}

	public void setSjId(String sjId) {
		this.sjId = sjId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getSjName() {
		return sjName;
	}

	public void setSjName(String sjName) {
		this.sjName = sjName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getcDay() {
		return cDay;
	}

	public void setcDay(Date cDay) {
		this.cDay = cDay;
	}

	@Override
	public String toString() {
		return "sId=" + sId + ", sjId=" + sjId + ", sName=" + sName + ", sjName=" + sjName + ", grade=" + grade
				+ ", cDay=" + cDay;
	}

}
