package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;



import connect.connectDB;
import model.comment;

public class commentDao {
     Connection con = null ;
     PreparedStatement ps = null ;
     ResultSet rs = null ;
     public ArrayList<comment> getCurrentUser(int id_match , int id_user)
     {
    	 ArrayList<comment> commentUser =  new ArrayList<comment>();
    	 try {
			con =  connectDB.getConnection();
			String query = "SELECT mywweb.user.fullname , mywweb.user.img , mywweb.comment.content , mywweb.comment.date  FROM mywweb.user inner join mywweb.comment on mywweb.user.id = mywweb.comment.id_user inner join mywweb.match on \r\n"
					+ "mywweb.comment.id_match = mywweb.match.id where id_match = ? and id_user =  ? order by mywweb.comment.date desc limit 1 ;";
			ps = con.prepareStatement(query);
			ps.setInt(1,id_match);
			ps.setInt(2,id_user);
			rs = ps.executeQuery();
			while(rs.next())
			{
				commentUser.add(new comment(rs.getString("fullname"), rs.getString("img"), rs.getString("content"), rs.getDate("date")));
				
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
		 e.printStackTrace();
		}
    	 return commentUser;
     }
     public void updateComment(int id_user , int id_match , String content , Date currentDate)
     {
    	 con  =  connectDB.getConnection();
    	 try {
			String query = "UPDATE mywweb.comment\r\n"
					+ " SET mywweb.comment.content = ? , mywweb.comment.date = ?\r\n"
					+ " where mywweb.comment.id_user = ? and mywweb.comment.id_match=?";
			ps =  con.prepareStatement(query);
			ps.setString(1,content);
			ps.setDate(2,(java.sql.Date)currentDate);
			ps.setInt(3, id_user);
			ps.setInt(4, id_match);	
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 
     }
     public ArrayList<comment> getAllComment(int id_match , int id_seasion)
     {
    	 ArrayList<comment> allComment  =  new ArrayList<comment>();
    	 try {
			con =  connectDB.getConnection();
			String query = "SELECT mywweb.user.fullname , mywweb.user.img , mywweb.comment.content , mywweb.comment.date ,mywweb.comment.id_user ,mywweb.comment.id FROM mywweb.user\r\n"
					+ "inner join mywweb.comment on mywweb.user.id = mywweb.comment.id_user \r\n"
					+ "inner join mywweb.match on \r\n"
					+ "mywweb.comment.id_match = mywweb.match.id where id_match = ? and id_season =  ? order by mywweb.comment.date desc ";
			ps = con.prepareStatement(query);
			ps.setInt(1, id_match);
			ps.setInt(2, id_seasion);
			rs =  ps.executeQuery();
			while(rs.next())
			{
				allComment.add(new comment(rs.getString("fullname"),rs.getString("img"),rs.getString("content") ,rs.getDate("date"),rs.getInt("id_user"),rs.getInt("id")));
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
		 e.printStackTrace();
		}
    	 return allComment ;
     }
     public void addCommentByUserId(int id  , int id_match,Date time, String comment)
     {
    	 try {
			con  = connectDB.getConnection();
			String query = "insert into comment  (content , id_match , id_user , date) values (?,?,?,?) ;";
			ps  = con.prepareStatement(query);
			ps.setString(1,comment);
			ps.setInt(2, id_match);
			ps.setInt(3, id);
			ps.setDate(4,(java.sql.Date) time);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     public void  deleteCommentById(int id_comment)
     {
    	 try {
			con = connectDB.getConnection();
			String query = "delete from comment where id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1,id_comment);
			ps.executeUpdate();
		    connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     public static void main(String[] args) {
		commentDao dao  = new commentDao();
		//ArrayList<comment> arr = dao.getAllComment(1,1);
	//for (comment comment : arr) {
	//	System.out.println(comment);
	//}
		dao.deleteCommentById(1);
	}
     public void updateCommentById(int id , String content)
     {
    	 try {
			con  = connectDB.getConnection();
			String query = "update comment set content = ? where id = ?";
			ps  = con.prepareStatement(query);
			ps.setString(1,content);
			ps.setInt(2,id);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
}
