package admindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.connectDB;
import model.commentModel;

public class commentDao {
    private Connection con  = null ;
    private ResultSet rs = null ;
    private PreparedStatement ps = null ;
    public ArrayList<commentModel> getAllArrComment ()
    {
    	ArrayList<commentModel> arr =  new ArrayList<commentModel>();
    	try {
			con  = connectDB.getConnection();
			String query = "select * from mywweb.comment ;";
			ps =  con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				arr.add(new commentModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getDate(5)));
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
	       e.printStackTrace();
		}
    	return arr ;
    }
    public void deleteCommentById(int id)
    {
    	con =  connectDB.getConnection();
    	try {
			String query = "delete from mywweb.comment where id = ? ;";
			ps = con.prepareStatement(query);
			ps.setInt(1,id);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static void main(String[] args)
    {
    	commentDao t  =  new commentDao();
    	ArrayList<commentModel> arr = t.getAllArrComment();
    	for (commentModel commentModel : arr) {
			System.out.println(commentModel);
		}
    	
    }
    
}
