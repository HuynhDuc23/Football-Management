package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.playerDao;
import dao.teamDao;
import model.player;
import model.team;

/**
 * Servlet implementation class DetailClubServlet
 */
@WebServlet("/DetailClubServlet")
public class DetailClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailClubServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		int idClub = Integer.parseInt(id);
		teamDao teamClub = new teamDao();
		team idTeam = teamClub.getIdTeamClub(idClub);
		// lay ra tat ca cac cau thu thuoc team do
		playerDao dao = new playerDao();
		ArrayList<player> playerMember = dao.getAllPlayerTeam(idClub);
		request.setAttribute("playerMember", playerMember);

		request.setAttribute("idTeam", idTeam);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
