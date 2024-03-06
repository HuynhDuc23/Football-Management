package model;

public class player {
     private int id ;
     private String name ;
     private int shirt ;
     private int id_team ;
     public player()
     {
    	 
     }
     public player(String name)
     {
    	 this.name = name ;
     }
     public player(int id , String name , int shirt , int id_team)
     {
    	 this.id = id ;
    	 this.name = name ;
    	 this.shirt = shirt ;
    	 this.id_team = id_team ;
     }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getShirt() {
		return shirt;
	}
	public void setShirt(int shirt) {
		this.shirt = shirt;
	}
	public int getId_team() {
		return id_team;
	}
	public void setId_team(int id_team) {
		this.id_team = id_team;
	}
	@Override
	public String toString() {
		return "player [id=" + id + ", name=" + name + ", shirt=" + shirt + ", id_team=" + id_team + "]";
	}
     
     
}
