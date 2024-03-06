package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.connectDB;
import model.user;

public class userDao {
   private Connection con  = null ;
   private PreparedStatement ps = null ;
   private ResultSet rs= null ;
   public user getByIdAccount(int id)
   {
	   user use = null ;
	   try {
		 con = connectDB.getConnection();
		 String query ="SELECT * FROM mywweb.user where id_account = ? ;";
		 ps = con.prepareStatement(query);
		 ps.setInt(1, id);
		 rs = ps.executeQuery();
		 while(rs.next())
		 {
			 return new user(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getInt(5));
		 }
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return use ;
   }
   public void editAccountFile (int id , String name , int age , String img )
   {
	   if(!img.equals(""))
	   {
		   try {
			con = connectDB.getConnection();
			String query = "update user set fullname = ? , age = ? , img = ? where id = ?";
			ps  =  con.prepareStatement(query);
			ps.setString(1,name);;
			ps.setInt(2,age);
			ps.setString(3,img);
			ps.setInt(4,id);
			ps.executeUpdate() ;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		   connectDB.closeConnection(con);
	   }
	   else
	   {
		   try {
				con = connectDB.getConnection();
				String query = "update user set fullname = ? , age = ? where id = ?";
				ps  =  con.prepareStatement(query);
				ps.setString(1,name);;
				ps.setInt(2,age);
				ps.setInt(3,id);
				ps.executeUpdate() ;
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			   connectDB.closeConnection(con);
	   }
   }
   public user getByIdUser(int id)
   {
	   user user  =  null ;
	   try {
		  con =  connectDB.getConnection();
		  String query = "SELECT * FROM mywweb.user where id_account =  ?";
		  ps  = con.prepareStatement(query);
		  ps.setInt(1,id);
		  rs =  ps.executeQuery();
		  while(rs.next())
		  {
			  return new user(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
		  }
		  connectDB.closeConnection(con);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return user ;
   }
   public void inSertInformationUser(int id_account , String name , int age , String img)
   {
	   con = connectDB.getConnection();
	   if(img.equals(""))
	   {
		   try {
			String query = "insert into user (fullname , age , id_account ) values (?,?,?);";
			ps =  con.prepareStatement(query);
			ps.setString(1,name);
			ps.setInt(2,age);
			ps.setInt(3,id_account);
			ps.executeUpdate();
		     connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	   }
	   else
	   {
		   try {
			String query ="insert into user (fullname , age , img , id_account ) values (?,?,?,?);";
			ps =  con.prepareStatement(query);
			ps.setString(1,name);
			ps.setInt(2,age);
			ps.setString(3,img);
			ps.setInt(4,id_account);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	   }
	   
   }
   public static void main(String args[])
   {
	   userDao dao  =  new userDao();
	     dao.inSertInformationUser(76, "hello", 12,"123");
   }
}
