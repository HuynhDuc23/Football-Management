package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.connectDB;
import model.team;

public class teamDao {
     private Connection con  =  null ;
     private ResultSet rs = null ;
     private PreparedStatement ps = null ;
     public ArrayList<team> getTopByIdSession(int id)
     {
    	 ArrayList<team> teamTop = new ArrayList<team>();
    	 try {
			con =  connectDB.getConnection();
			String query =  "select team.* , team_detail.id_season from team inner join team_detail on team.id = team_detail.id_team where id_season = ? ;";
		    ps =  con.prepareStatement(query);
		    ps.setInt(1, id);
		    rs = ps.executeQuery();
		    while(rs.next())
		    {
		    	teamTop.add(new team(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
		    }
		    connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return teamTop ;
     }
     public team getIdTeamClub(int id)
     {
    	 team getId =  null ;
    	 try {
			con  = connectDB.getConnection();
			String query = "SELECT * FROM mywweb.team where id  = ? ;";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs =  ps.executeQuery() ;
			while(rs.next())
			{
				getId =  new team(rs.getInt("id"), rs.getString("name"), rs.getString("name_arena"),rs.getString("logo"), rs.getString(5), rs.getString(6));
				return getId;
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return getId;
     }
     public int CountAllTeam()
     {
    	 int count = 0 ;
    	 try {
			con  =  connectDB.getConnection();
			String query = "SELECT count(*)FROM mywweb.team;";
			ps = con.prepareStatement(query);
			rs  =  ps.executeQuery();
			while(rs.next())
			{
				count =  rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return count ;
     }
     public ArrayList<team> pagingGetAllTeam(int index)
     {
    	 ArrayList<team> teamPaging =  new ArrayList<team>();
    	try {
			con  =  connectDB.getConnection();
			String query = "select * from team order by id limit 3 offset ?;";
			ps  = con.prepareStatement(query);
			ps.setInt(1, ((index-1)*3));
			rs = ps.executeQuery();
			while(rs.next())
			{
				teamPaging.add(new team(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return teamPaging;
     }
     public int countTeamSearch(String txt)
     {
    	 int count  = 0 ;
    	 try {
		     con  =  connectDB.getConnection();
		     String query  = "select count(*) from team where name like ? ;";
		     ps  =  con.prepareStatement(query);
		     ps.setString(1,"%"+txt+"%");
		     rs =  ps.executeQuery();
		     while(rs.next())
		     {
		    	 return count  =  rs.getInt(1);
		     }
		     
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return count ;
     }
     public ArrayList<team> getAllTeamPaging(String txt , int index)
     {
    	 ArrayList<team> teamPaging =  new ArrayList<team>();
    	 try {
			con =  connectDB.getConnection();
			String query = "select * from team where name like ? limit 3 offset ? ;";
			ps  = con.prepareStatement(query);
			ps.setString(1,"%"+txt+"%");
			ps.setInt(2,(index-1)*3);
			rs =  ps.executeQuery();
			while(rs.next())
			{
				teamPaging.add(new team(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));		
			}
			connectDB.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return teamPaging;
     }
     public static void main(String[] args) {

		teamDao dao =  new teamDao();
	   ArrayList<team> t =  dao.getAllTeamPaging("d",1);
	   for (team team : t) {
		System.out.println(t);
	}
	    
	}
}
