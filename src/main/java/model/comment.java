package model;

import java.sql.Date;

public class comment {
    private String fullname ;
    private String img ;
    private String content ;
    private Date date ;
    private int id_user ;
    private int id ;
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	
    public comment(String fullname, String img, String content, Date date, int id_user, int id) {
		super();
		this.fullname = fullname;
		this.img = img;
		this.content = content;
		this.date = date;
		this.id = id;
		this.id_user = id_user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public comment()
    {
    	
    }
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "comment [fullname=" + fullname + ", img=" + img + ", content=" + content + ", date=" + date
				+ ", id_user=" + id_user + ", id=" + id + "]";
	}

	public comment(String fullname, String img, String content, Date date) {
		super();
		this.fullname = fullname;
		this.img = img;
		this.content = content;
		this.date = date;
	}
	
    
	
    
}
