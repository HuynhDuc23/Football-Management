package admindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.connectDB;
import model.player;

public class playerTeam {
    private Connection con  = null ;
    private ResultSet rs = null;
    private PreparedStatement ps =  null ;
    public ArrayList<model.playerTeam> getAlLPlayerTeam()
    {
    	ArrayList<model.playerTeam> arr = new ArrayList<model.playerTeam>();
    	try {
			con  = connectDB.getConnection();
			String query = "select mywweb.player.id , mywweb.player.name , mywweb.player.shirt , mywweb.team.name , mywweb.player.id_team \r\n"
					+ "from mywweb.team inner join\r\n"
					+ " mywweb.player on mywweb.team.id =  mywweb.player.id_team";
			ps  =  con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				arr.add(new model.playerTeam(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5)));
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return arr ;
    }
    public void deletePlayTeamBtId(int id)
    {
    	try {
			con  =  connectDB.getConnection();
			String query = "delete from  mywweb.player where mywweb.player.id = ? ;";
			ps =  con.prepareStatement(query);
			ps.setInt(1,id);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public model.player getPlayerById(int id)
    {
    	model.player player =  null ;
    	try {
    		con = connectDB.getConnection();
			String query = "select * from player where id =  ? ";
			ps =  con.prepareStatement(query);
			ps.setInt(1,id);
			rs =  ps.executeQuery();
			while(rs.next())
			{
				return player =  new model.player(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));			
			}
			connectDB.closeConnection(con);	
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return player ;
    }
    public void updatePlayerById(int id ,  String name , int shirt , int id_team)
    {
    	con =  connectDB.getConnection();
    	try {
			String query = "update mywweb.player set name = ? , shirt = ? , id_team = ? where id = ? ;";
			ps =  con.prepareStatement(query);
			ps.setString(1,name);
			ps.setInt(2,shirt);
			ps.setInt(3,id_team);
			ps.setInt(4,id);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public void addPlayer(String name , int shirt , int id_team)
    {
    	con = connectDB.getConnection();
    	try {
			String query = "insert into mywweb.player (name , shirt , id_team) values (?,?,?);";
			ps =  con.prepareStatement(query);
			ps.setString(1,name);
			ps.setInt(2,shirt);
			ps.setInt(3,id_team);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static void main(String args[])
    {
    	playerTeam t = new playerTeam();
    	try {
//    		t.updatePlayerById(59,"ddfsdadsad",2,3);
		} catch (Exception e) {
		    e.printStackTrace();
		}
        
    }
}
