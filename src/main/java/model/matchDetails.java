package model;

import java.sql.Date;

public class matchDetails {
   private int id_match ;
   public int getId_match() {
	return id_match;
}

public void setId_match(int id_match) {
	this.id_match = id_match;
}

private String name  ;
   private String logo ;
   private int score ;
   private Date date ;
   private int card ;
   private String studium ;
   
   public matchDetails()
   {
	   
   }

public String getStudium() {
	return studium;
}

public void setStudium(String studium) {
	this.studium = studium;
}

public matchDetails(int id_match,String name, String logo, int score, Date date, int card,String studium) {
	super();
	this.id_match =  id_match ;
	this.name = name;
	this.logo = logo;
	this.score = score;
	this.date = date;
	this.card = card;
	this.studium = studium ;
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

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public int getCard() {
	return card;
}

public void setCard(int card) {
	this.card = card;
}

@Override
public String toString() {
	return "matchDetails [id_match=" + id_match + ", name=" + name + ", logo=" + logo + ", score=" + score + ", date="
			+ date + ", card=" + card + ", studium=" + studium + "]";
}




   

}
