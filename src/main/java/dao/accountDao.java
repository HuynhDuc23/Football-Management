package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import connect.connectDB;
import model.account;

public class accountDao {
      private Connection con  = null ;
      private PreparedStatement ps =  null ;
      private ResultSet rs =  null ;
      
      public account loginAccount(String email , String password)
      {
    	  account acc = null ;
    	 try {
			con = connectDB.getConnection();
			String query = "select * from account where email = ? and password = ?;";
			ps =  con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2, password);
			rs =  ps.executeQuery();
			while(rs.next())
			{
				return new account(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	  return acc ;
      }
      public account checkEmailAndPass(String email , String pass)
      {
    	   account acc =  null ;
    	   try {
			con = connectDB.getConnection() ;
			String query = "select * from account where email  = ? and password = ? ;";
			ps  =  con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2,pass);
			rs =  ps.executeQuery();
			while(rs.next())
			{
				return new account(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	  return acc ;
      }
      public void signUp(String email, String pass)
      {
    	 try {
			con = connectDB.getConnection();
			String query = "insert into account (email , password , role) values(?,?,?);";
			ps =  con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,pass);
			ps.setInt(3, 0);
		   int count =  ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
      }
      public account checkEmail(String email)
      {
    	  account acc =  null ;
    	  try {
			 con = connectDB.getConnection();
			 String query =  "SELECT * FROM mywweb.account where email = ? ;";
			 ps  =  con.prepareStatement(query);
			 ps.setString(1,email);
			 rs =  ps.executeQuery();
			 while(rs.next())
			 {
				return acc = new account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				 
			 }
			 connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	  return acc ;
      }
      public void updateAccountNewChange(String email , String passNew)
      {
    	  try {
			con =  connectDB.getConnection();
			String query = "update account set email = ?  , password = ? where email = ? ;";
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, passNew);
			ps.setString(3, email);
			 ps.executeUpdate();
			connectDB.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
      }
      public List<account> getAllAccount(String email) {
  		List<account> list = new ArrayList<account>();
  		try {
  			con = connectDB.getConnection();
  			String query = "select * from mywweb.account where account.email = ?";
  			ps = con.prepareStatement(query);
  			ps.setString(1,email);
  			rs = ps.executeQuery();
  			while (rs.next()) {
  				list.add(new account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
  			}
  			connectDB.closeConnection(con);
  		} catch (Exception e) {
  			// TODO: handle exception
  		}
  		return list;
  	}
      public static void main(String[] args) {
		accountDao dao  =  new accountDao();
		account acc =  dao.checkEmail("ductrantad23@gmail.com");
		System.out.println(acc);
	}
    
      
}
