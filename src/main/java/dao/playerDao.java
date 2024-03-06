package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.connectDB;
import model.player;
import model.user;

public class playerDao {

    private Connection con =  null;
    private ResultSet rs = null ;
    private PreparedStatement ps =  null ;
    public ArrayList<player> getAllPlayerTeam(int id_team)
    {
       ArrayList<player> userList = new ArrayList<player>();
       try {
		   con  = connectDB.getConnection();
		   String query = "SELECT PLAYER.name FROM mywweb.team INNER JOIN PLAYER ON TEAM.ID =  PLAYER.ID_TEAM WHERE TEAM.ID = ? ;";
		   ps = con.prepareStatement(query);
		   ps.setInt(1,id_team);
		   rs =  ps.executeQuery();
		   while(rs.next())
		   {
			  String name  = rs.getString(1);
			  player player = new player(name);
			  userList.add(player);
		   }
		   connectDB.closeConnection(con);
		   	   
} catch (Exception e) {
		e.printStackTrace();
	}
       return userList ;
      
      
    }
    public static void main(String[] args) {
		ArrayList<player> pl  =  new ArrayList<player>();
		playerDao play = new playerDao();
		pl =  play.getAllPlayerTeam(6);
		for (player player : pl) {
			System.out.println(player);
			
		}
	}
}
