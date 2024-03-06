package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.connectDB;
import model.match;
import model.matchDetailTeam;
import model.matchDetails;
import model.matchGoal;

public class matchDetailsServletDao {
      private Connection con  =  null ;
      private PreparedStatement ps = null ;
      private ResultSet rs = null ;
      public matchDetailTeam selectById(int idMatchDetail) {
  		// TODO Auto-generated method stub
  		matchDetailTeam matchDetail = null;
  		try {
  			con  = connectDB.getConnection();
			String query = "select * from mywweb.match_detail where id = ?;";
			ps = con.prepareStatement(query);
			ps.setInt(1,idMatchDetail);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int id_team = rs.getInt("id_team");
				int id_match = rs.getInt("id_match");
				int status = rs.getInt("status");
				int score = rs.getInt("score");
				int id = rs.getInt("id");
				String studium = rs.getString("studium");
				return matchDetail = new matchDetailTeam(id_match, id_team, status, studium, id, score);
			}
			connectDB.closeConnection(con);
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return null;
  	}
      public ArrayList<matchDetails> getMatchDetails (int id_match , int id_session)
      {
    	  ArrayList<matchDetails> match  =  new ArrayList<matchDetails>();
    	  try {
			con  = connectDB.getConnection();
			String query = "select * from mywweb.team inner join mywweb.match_detail\r\n"
					+ "on mywweb.team.id =  mywweb.match_detail.id_team\r\n"
					+ "inner join mywweb.match on mywweb.match.id =  mywweb.match_detail.id_match \r\n"
					+ "where id_match =  ? and mywweb.match.id_season = ? ;";
			ps = con.prepareStatement(query);
			ps.setInt(1,id_match);
			ps.setInt(2,id_session);
			rs = ps.executeQuery();
			while(rs.next())
			{
				match.add(new matchDetails(rs.getInt("id_match"),rs.getString("name"), rs.getString("logo"), rs.getInt("score"), rs.getDate("date"), rs.getInt("card"),rs.getString("studium")));
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	  return match ;
      }
      public ArrayList<matchGoal> getMatchPlayer(int id_match , int id_team)
      {
    	  ArrayList<matchGoal> matchGoal =  new ArrayList<matchGoal>();
    	  try {
			con =  connectDB.getConnection();
			String query = "select * from player inner join  player_detail on player.id =  player_detail.id_player\r\n"
					+ "inner join mywweb.match on player_detail.id_match =  mywweb.match.id\r\n"
					+ "inner join mywweb.goal on mywweb.goal.id_player_detail = mywweb.player_detail.id \r\n"
					+ "where id_match = ? and id_team = ? ;";
			ps  = con.prepareStatement(query);
			ps.setInt(1,id_match);
			ps.setInt(2,id_team);
			rs = ps.executeQuery();
			while(rs.next())
			{
				matchGoal.add(new matchGoal(rs.getString("name") , rs.getInt("card"), rs.getInt("minute")));
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
		    e.printStackTrace();
		}
    	  return matchGoal;
    	  
      }
      
      
      public matchDetailTeam getMatchDetail(int idParam )
      {
    	  matchDetailTeam matchDetailTeam = null;
    	  try {
			con =  connectDB.getConnection();
			String query = "select * from match_detail where id = ?";
			ps  = con.prepareStatement(query);
			ps.setInt(1,idParam);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int id_team = rs.getInt("id_team");
				int id_match = rs.getInt("id_match");
				int status = rs.getInt("status");
				int score = rs.getInt("score");
				int id = rs.getInt("id");
				String studium = rs.getString("studium");
				matchDetailTeam = new matchDetailTeam(id_match, id_team, status, studium, id, score);
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
		    e.printStackTrace();
		}
    	  return matchDetailTeam;
    	  
      }
      
      
      public int updateMatchDetail(int idParam, int score )
      {
    	  int rs = 0;
    	  try {
			con =  connectDB.getConnection();
			String query = "update match_detail set score = ? where id = ? ";
			ps  = con.prepareStatement(query);
			ps.setInt(1,score);
			ps.setInt(2,idParam);
			rs = ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
		    e.printStackTrace();
		}
    	  return rs;
    	  
      }
      
      
      
      public static void main(String[] args) {
		matchDetailsServletDao dao  = new matchDetailsServletDao();
//		ArrayList<matchDetails> arr = dao.getMatchDetails(1,1);
//		for (matchDetails matchDetails : arr) {
//			System.out.println(matchDetails);
//			
//		}
		System.out.println(dao.updateMatchDetail(2,1));
	}
}
