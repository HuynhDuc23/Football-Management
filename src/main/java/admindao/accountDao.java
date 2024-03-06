package admindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connectDB;
import model.account;
import model.user;

public class accountDao {
     Connection con  = null ;
     ResultSet rs = null ;
     PreparedStatement ps = null ;
     
     public ArrayList<account> getAllAccount()
     {
    	 ArrayList<account> arr = new ArrayList<account>();
    	 
    	 try {
			con  = connectDB.getConnection();
			String query = "SELECT * FROM mywweb.account;";
			ps  = con.prepareStatement(query);
			rs  =  ps.executeQuery();
			while(rs.next())
			{
				arr.add(new account(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getInt(4)));
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return arr ;
     }
     public void deleteAccount(int id)
     {
    	 try {
			con  = connectDB.getConnection();
			String query = "delete from mywweb.account where mywweb.account.id = ?";
			 ps =  con.prepareStatement(query);
			 ps.setInt(1,id);
			 ps.executeUpdate();
			 connectDB.closeConnection(con);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     public void  InsertAccInAdmin(String email , String pass , int  role)
     {
    	 con  = connectDB.getConnection();
    	 try {
			String query = "insert into account (email,password ,role) values(? ,? ,?);";
			ps =  con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,pass);
			ps.setInt(3,role);
			ps.executeUpdate();
			connectDB.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     public static void main(String[] args) {
	     
	     
	}

}
