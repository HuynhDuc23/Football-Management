package admindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.connectDB;
import model.user;

public class userDao {
     Connection con = null ;
     PreparedStatement ps =  null ;
     ResultSet rs = null ;
     public  ArrayList<user> getAllUser()
     {
    	 ArrayList<user> users = new ArrayList<user>();
    	 try {
			con = connectDB.getConnection();
			String query = "SELECT * FROM mywweb.user;";
			ps =  con.prepareStatement(query);
		    rs =  ps.executeQuery();
		    while(rs.next())
		    {
		    	users.add(new user(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getInt(5)));
		    	
		    }
		    connectDB.closeConnection(con);
		} catch (Exception e) {
		   e.printStackTrace();
		}
    	 return users ;
     }
     public void deleteUserOfAdmin(int id)
     {
    	 con  = connectDB.getConnection();
    	 try {
			String query = "delete FROM mywweb.user where id  =  ? ;";
			ps =  con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			connectDB.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     public void updateUserById(int id , String name , int age , String img)
     {
    	 con  =  connectDB.getConnection();
    	 if(img.equals(""))
    	 {
    		 try {
				String query = "update  mywweb.user set fullname = ? , age = ? where id = ?";
				ps =  con.prepareStatement(query);
				ps.setString(1,name);
				ps.setInt(2,age);
				ps.setInt(3,id);
				ps.executeUpdate();
			    connectDB.closeConnection(con);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	 }
    	 else
    	 {
    		 try {
 				String query = "update  mywweb.user set fullname = ? , age = ? , img = ? where id = ?";
 				ps =  con.prepareStatement(query);
 				ps.setString(1,name);
 				ps.setInt(2,age);
 				ps.setString(3,img);
 				ps.setInt(4,id);
 				ps.executeUpdate();
 			    connectDB.closeConnection(con);
 				
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
    	 }
     }
     public static void main(String[] args) {
		userDao dao  =  new userDao();
		ArrayList<user> user =  dao.getAllUser();
		for (user user2 : user) {
			System.out.println(user2);
		}
	}
}
