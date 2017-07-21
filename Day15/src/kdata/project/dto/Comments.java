package kdata.project.dto;

import java.io.Serializable;
import java.sql.Date;

public class Comments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7759765520357415199L;
	private int commentNum;
	private String id;
	private String content;
	private Date writeDate;
	private int num;

	public Comments(){
		
	}

	public Comments(String id, String content, int num) {
		super();
		this.id = id;
		this.content = content;
		this.num = num;
	}

	public Comments(int commentNum, String id, String content, Date writeDate, int num) {
		super();
		this.commentNum = commentNum;
		this.id = id;
		this.content = content;
		this.writeDate = writeDate;
		this.num = num;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Comments [commentNum=" + commentNum + ", id=" + id + ", content=" + content + ", writeDate=" + writeDate
				+ ", num=" + num + "]";
	}

}
