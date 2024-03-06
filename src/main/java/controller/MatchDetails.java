package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.commentDao;
import dao.matchDetailsServletDao;
import dao.sessionDao;
import model.account;
import model.comment;
import model.matchDetails;
import model.matchGoal;
import model.user;

/**
 * Servlet implementation class MatchDetails
 */
@WebServlet("/MatchDetails")
public class MatchDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MatchDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idteam1 = (String) request.getParameter("id_team_1");
		String idteam2 = (String) request.getParameter("id_team_2");
		String session = (String) request.getSession().getAttribute("session");
		String id_match = (String) request.getParameter("id_match");

		matchDetailsServletDao dao = new matchDetailsServletDao();
		ArrayList<matchDetails> matchDetails = dao.getMatchDetails(Integer.parseInt(id_match),
				Integer.parseInt(session));

		// goal idteam1
		ArrayList<matchGoal> matchGoalTeam1 = dao.getMatchPlayer(Integer.parseInt(id_match), Integer.parseInt(idteam1));
		request.setAttribute("matchGoals1", matchGoalTeam1);
		// goal idteam2
		ArrayList<matchGoal> matchGoalTeam2 = dao.getMatchPlayer(Integer.parseInt(id_match), Integer.parseInt(idteam2));
		request.setAttribute("matchGoals2", matchGoalTeam2);
		// detail match
		request.setAttribute("matchDetails", matchDetails);

		// session
		sessionDao sessionDao = new sessionDao();
		ArrayList<model.session> getPresent = sessionDao.getPresent(Integer.parseInt(session));
		request.setAttribute("sessionPresent", getPresent);
		// userCurent
		user user = (user) request.getSession().getAttribute("user");

		commentDao dao1 = new commentDao();
		ArrayList<comment> userCurrent = dao1.getCurrentUser(Integer.parseInt(id_match), (user.getId()));
		request.setAttribute("userCurrent", userCurrent);
		// all getcomment
		ArrayList<comment> getAllComment = dao1.getAllComment(Integer.parseInt(id_match), Integer.parseInt(session));
		request.setAttribute("getAllComment", getAllComment);

		// set id_match , id_team_1 , id_team_2 ngược lại
		// request.setAttribute("idteam1",idteam1);
		// request.setAttribute("idteam2",idteam2);
		// request.setAttribute("id_match",id_match);
		request.getRequestDispatcher("matchDetails.jsp").forward(request, response);

	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
