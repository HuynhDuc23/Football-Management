package admindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.connectDB;
import model.session;

public class seasionDao {
     private Connection con  = null ;
     private PreparedStatement ps = null;
     private ResultSet rs = null;
     public ArrayList<session> getAllSeasion()
     {
    	 ArrayList<session> seasionArr = new ArrayList<session>();
    	 con  =  connectDB.getConnection();
    	 try {
			String query = "SELECT * FROM mywweb.season;";
			ps = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next())
			{
				seasionArr.add(new session(rs.getInt(1),rs.getInt(2), rs.getInt(3)));
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return seasionArr ;
     }
     public void deleteSeasionById(int id)
     {
    	 con = connectDB.getConnection();
    	 try {
			String query = "delete FROM mywweb.season where id =  ? ;";
			ps =  con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     public void insertSeasion(int start , int end)
     {
    	 con =  connectDB.getConnection();
    	 try {
			String query = "insert into season(year_start,year_end) values(?,?);";
			ps =  con.prepareStatement(query);
			ps.setInt(1,start);
			ps.setInt(2,end);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     public static void main(String args[])
     {
    	 seasionDao dao  = new seasionDao();
    	 ArrayList<session> arr = dao.getAllSeasion();
    	 for (session session : arr) {
			System.out.println(session);
		}
     }
}
