package model;

public class match {
	private int id_team;
	private int id_match;
	private int status;
	private int score;
	private String name;
	private String logo;

	public match() {

	}

	public match(int id_team, int id_match, int status, int score, String name, String logo) {
		super();
		this.id_team = id_team;
		this.id_match = id_match;
		this.status = status;
		this.score = score;
		this.name = name;
		this.logo = logo;
	}

	public int getId_team() {
		return id_team;
	}

	public void setId_team(int id_team) {
		this.id_team = id_team;
	}

	public int getId_match() {
		return id_match;
	}

	public void setId_match(int id_match) {
		this.id_match = id_match;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	@Override
	public String toString() {
		return "match [id_team=" + id_team + ", id_match=" + id_match + ", status=" + status + ", score=" + score
				+ ", name=" + name + ", logo=" + logo + "]";
	}

}
