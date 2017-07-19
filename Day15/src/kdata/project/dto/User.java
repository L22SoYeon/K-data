package kdata.project.dto;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 270626856284165866L;
	private String id;
	private String pwd;
	private String name;
	private String profile;
	private Date regDate;
	

	public User() {
	}

	public User(String id, String pwd, String name, String profile) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.profile = profile;
	}

	public User(String id, String pwd, String name, String profile, Date regDate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.profile = profile;
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}


	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", name=" + name + ", profile=" + profile 
				+ "]";
	}

}
