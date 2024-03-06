package admindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.connectDB;
import model.matchDetailTeam;
import model.team;

public class teamDao {
	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public ArrayList<team> getArrTeam() {
		ArrayList<team> arrTeam = new ArrayList<team>();
		con = connectDB.getConnection();
		try {
			String query = "SELECT * FROM mywweb.team;";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				arrTeam.add(new team(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6)));
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrTeam;
	}

	public void deleteTeamById(int id) {
		con = connectDB.getConnection();
		try {
			String query = "delete FROM mywweb.team where id  = ? ;";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertTeam(String name, String logo, String namearena, String imgarena, String description) {
		con = connectDB.getConnection();
		try {
			String query = "insert into mywweb.team(name,name_arena,logo,img_arena,mywweb.team.description) values (?,?,?,?,?);";
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, namearena);
			ps.setString(3, logo);
			ps.setString(4, imgarena);
			ps.setString(5, description);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public team getTeamById(int id) {
		team getTeam = null;
		try {
			con = connectDB.getConnection();
			String query = "select * from mywweb.team where id  =  ? ;";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				getTeam = new team(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
				return getTeam;
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getTeam;
	}

	public void updateTeamById(int id, String name, String name_arena, String logo, String img_are,
			String description) {
		con = connectDB.getConnection();
		try {
			String query = "update mywweb.team set name = ? , name_arena = ? , logo = ? , img_arena = ? , mywweb.team.description = ?  where id = ? ;";
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, name_arena);
			ps.setString(3, logo);
			ps.setString(4, img_are);
			ps.setString(5, description);
			ps.setInt(6, id);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<model.team> getID() {
		ArrayList<model.team> getid = new ArrayList<team>();
		try {
			con = connectDB.getConnection();
			String query = "SELECT mywweb.team.id, mywweb.team.name FROM mywweb.team;";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				getid.add(new team(rs.getInt(1), rs.getString(2)));
			}
			connectDB.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getid;
	}

	public ArrayList<matchDetailTeam> getAllMatchDetails() {
		ArrayList<matchDetailTeam> arr = new ArrayList<matchDetailTeam>();
		try {
			con = connectDB.getConnection();
			String query = "select mywweb.match.id , mywweb.match.date , mywweb.match.id_season , mywweb.match_detail.status , mywweb.match_detail.studium , mywweb.match_detail.id\r\n"
					+ "					, mywweb.team.name , mywweb.team.logo , mywweb.match_detail.score , mywweb.team.id from mywweb.match  inner join mywweb.match_detail on mywweb.match.id =  \r\n"
					+ "					mywweb.match_detail.id_match  inner join mywweb.team  on mywweb.match_detail.id_team = mywweb.team.id \r\n"
					+ "                   ;";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				arr.add(new matchDetailTeam(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10)));

			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	public void deleteMatchDetailsById(int id) {
		try {
			con = connectDB.getConnection();
			String query = "delete from mywweb.match_detail where mywweb.match_detail.id_match = ? ;";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String args[]) {
		teamDao dao = new teamDao();
		//matchDetailTeam t = dao.getMatchDetailTeamById(1);
		//System.out.println(t);
		ArrayList<matchDetailTeam> t =  dao.getAllMatchDetails();
		for (matchDetailTeam matchDetailTeam : t) {
			System.out.println(matchDetailTeam);
		}
	}
}
