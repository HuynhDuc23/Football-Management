package model;

public class teamDetail {
    private int id_session ;
    private int id_team ;
    private int id ;
	public teamDetail(int id_session, int id_team, int id) {
		super();
		this.id_session = id_session;
		this.id_team = id_team;
		this.id = id;
	}
	public teamDetail() {
		super();
	}
	public int getId_session() {
		return id_session;
	}
	public void setId_session(int id_session) {
		this.id_session = id_session;
	}
	public int getId_team() {
		return id_team;
	}
	public void setId_team(int id_team) {
		this.id_team = id_team;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "teamDetail [id_session=" + id_session + ", id_team=" + id_team + ", id=" + id + "]";
	}
    
}
