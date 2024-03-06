package model;

public class user {
   private int id ;
   private String fullname ;
   private int age ;
   private String img ;
   private int id_account ;
public user() {
	super();
}
public user(int id, String fullname, int age, String img, int id_account) {
	super();
	this.id = id;
	this.fullname = fullname;
	this.age = age;
	this.img = img;
	this.id_account = id_account;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public int getId_account() {
	return id_account;
}
public void setId_account(int id_account) {
	this.id_account = id_account;
}
@Override
public String toString() {
	return "user [id=" + id + ", fullname=" + fullname + ", age=" + age + ", img=" + img + ", id_account=" + id_account
			+ "]";
}
   
}
