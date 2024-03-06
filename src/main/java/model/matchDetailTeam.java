package model;

import java.sql.Date;

public class matchDetailTeam {
	private int id_match ;
	private int id_team ;
	private Date date ;
	private int id_seasion ;
	private int status ;
	private String studium ;
	private int id_details ;
	private String name ;
	private String logo ;
	private int score ;
	public matchDetailTeam() {
		super();
	}
	
	public matchDetailTeam(int id_match, int id_team, Date date, int status, String studium, int id_details,
			String name, String logo, int score) {
		super();
		this.id_match = id_match;
		this.id_team = id_team;
		this.date = date;
		this.status = status;
		this.studium = studium;
		this.id_details = id_details;
		this.name = name;
		this.logo = logo;
		this.score = score;
	}

	public matchDetailTeam(int id_match, int id_team, int status, String studium, int id_details, int score) {
		super();
		this.id_match = id_match;
		this.id_team = id_team;
		this.status = status;
		this.studium = studium;
		this.id_details = id_details;
		this.score = score;
	}

	public matchDetailTeam(int id_match, Date date, int id_seasion, int status, String studium,
			int id_details, String name, String logo, int score, int id_team) {
		super();
		this.id_match = id_match;
		
		this.date = date;
		this.id_seasion = id_seasion;
		this.status = status;
		this.studium = studium;
		this.id_details = id_details;
		this.name = name;
		this.logo = logo;
		this.score = score;
		this.id_team = id_team;
	}
	public int getId_match() {
		return id_match;
	}
	public void setId_match(int id_match) {
		this.id_match = id_match;
	}
	public int getId_team() {
		return id_team;
	}
	public void setId_team(int id_team) {
		this.id_team = id_team;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId_seasion() {
		return id_seasion;
	}
	public void setId_seasion(int id_seasion) {
		this.id_seasion = id_seasion;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStudium() {
		return studium;
	}
	public void setStudium(String studium) {
		this.studium = studium;
	}
	public int getId_details() {
		return id_details;
	}
	public void setId_details(int id_details) {
		this.id_details = id_details;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "matchDetailTeam [id_match=" + id_match + ", id_team=" + id_team + ", date=" + date + ", id_seasion="
				+ id_seasion + ", status=" + status + ", studium=" + studium + ", id_details=" + id_details + ", name="
				+ name + ", logo=" + logo + ", score=" + score + "]";
	}
	

}
