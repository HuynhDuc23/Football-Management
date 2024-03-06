package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.connectDB;
import model.match;

public class matchDao {
     private Connection con  = null ;
     private PreparedStatement ps = null ;
     private ResultSet rs = null ;
     public ArrayList<match> getAllMatchSession(int id)
     {
    	 ArrayList<match> arr = new ArrayList<match>();
    	 try {
		  con = connectDB.getConnection();
		  // lay ra tat ca cac tran dau thuoc mot mua giai session 
		  String query = "select m.*, t.name, t.logo from match_detail m join team t on m.id_team=t.id join `match` on m.id_match=`match`.id where id_season=? ;";
		  ps  =  con.prepareStatement(query);
		  ps.setInt(1,id);
		  rs = ps.executeQuery();
		  while(rs.next())
		  {
			  arr.add(new match(rs.getInt("id_team"), rs.getInt("id_match"),rs.getInt("status"), rs.getInt("score"), rs.getString("name"), rs.getString("logo")));
		  }
		  connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return arr ;
     }
     public static void main(String[] args)
     {
    	 matchDao dao  = new matchDao();
    	 ArrayList<match> match = dao.getAllMatchSession(1);
    	 for (match match2 : match) {
			System.out.println(match2);
		}
     }
}
