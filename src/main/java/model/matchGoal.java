package model;

public class matchGoal {
   private String name ;
   private int minute ;
   private int card ;
   public matchGoal()
   {
	   
   };
   public matchGoal(String name , int card , int minute)
   {
	   this.name  =  name ;
	   this.minute =  minute ;
	   this.card = card ;
   }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMinute() {
	return minute;
}
public void setMinute(int minute) {
	this.minute = minute;
}
public int getCard() {
	return card;
}
public void setCard(int card) {
	this.card = card;
}
@Override
public String toString() {
	return "matchGoal [name=" + name + ", minute=" + minute + ", card=" + card + "]";
}

   
   
   
}
