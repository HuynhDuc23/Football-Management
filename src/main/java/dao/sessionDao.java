package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.connectDB;
import model.session;

public class sessionDao {
   private Connection con = null ;
   private ResultSet rs=  null ;
   private PreparedStatement ps = null ;
   public ArrayList<session> getAllSession()
   {
	   ArrayList<session>sessionR = new ArrayList<session>();
	   try {
		con = connectDB.getConnection();
		String query =  "SELECT * FROM mywweb.season;";
		ps = con.prepareStatement(query);
		rs =  ps.executeQuery();
		while(rs.next())
		{
		 sessionR.add(new session(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			
		}
		connectDB.closeConnection(con);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return sessionR ;
   }
   public ArrayList<session>  getPresent(int id) 
   {
	   ArrayList<session> session = new ArrayList<session>();
	   try {
		  con  =  connectDB.getConnection();
		  String query = "SELECT * FROM mywweb.season where id  = ? ;";
		  ps = con.prepareStatement(query);
		  ps.setInt(1,id);
		  rs = ps.executeQuery();
		  while(rs.next())
		  {
			  session.add(new session(rs.getInt(2),rs.getInt(3)));
		  }
		  connectDB.closeConnection(con);
				  
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return  session ;
   }
  public static void main(String[] args) {
	  sessionDao dao  = new sessionDao();
	  ArrayList<session>arr =  dao.getPresent(1);
	for (session session : arr) {
		System.out.println(session);
	}
}
}
