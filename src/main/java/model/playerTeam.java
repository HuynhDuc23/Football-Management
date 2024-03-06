package model;

public class playerTeam {
     private int id ;
     private String namePlayer ;
     private int shirt ;
     private String nameTeam ;
     private int idTeam ;
	public playerTeam() {
		super();
	}
	public playerTeam(int id, String namePlayer, int shirt, String nameTeam, int idTeam) {
		super();
		this.id = id;
		this.namePlayer = namePlayer;
		this.shirt = shirt;
		this.nameTeam = nameTeam;
		this.idTeam = idTeam;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamePlayer() {
		return namePlayer;
	}
	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}
	public int getShirt() {
		return shirt;
	}
	public void setShirt(int shirt) {
		this.shirt = shirt;
	}
	public String getNameTeam() {
		return nameTeam;
	}
	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}
	public int getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}
	@Override
	public String toString() {
		return "playerTeam [id=" + id + ", namePlayer=" + namePlayer + ", shirt=" + shirt + ", nameTeam=" + nameTeam
				+ ", idTeam=" + idTeam + "]";
	}
    
     
}
