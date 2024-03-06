package model;

import java.sql.Date;

public class commentModel {
	private int id ;
    private  String content ;
    private int id_match ;
    private int id_user ;
    private Date date ;
	public commentModel() {
		// TODO Auto-generated constructor stub
	}
	public commentModel(int id, String content, int id_match, int id_user, Date date) {
		super();
		this.id = id;
		this.content = content;
		this.id_match = id_match;
		this.id_user = id_user;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId_match() {
		return id_match;
	}
	public void setId_match(int id_match) {
		this.id_match = id_match;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "commentModel [id=" + id + ", content=" + content + ", id_match=" + id_match + ", id_user=" + id_user
				+ ", date=" + date + "]";
	}
	
	

}
