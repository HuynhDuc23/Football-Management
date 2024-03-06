package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.matchDao;
import dao.teamDao;
import model.match;
import model.team;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String session = request.getParameter("session");

		String sessionGet = (String) request.getSession().getAttribute("session");
		if (sessionGet != null) {
			sessionGet = session;
			request.getSession().setAttribute("session", sessionGet);

		} else {
			request.getSession().setAttribute("session", session);
		}
		teamDao dao = new teamDao();
		ArrayList<team> getAllTeamSession = dao.getTopByIdSession(Integer.parseInt(session));
		matchDao matchDao = new matchDao();
		ArrayList<match> getAllMatchSession = matchDao.getAllMatchSession(Integer.parseInt(session));
		request.setAttribute("matchSession", getAllMatchSession);
		request.setAttribute("team", getAllTeamSession);
		request.getRequestDispatcher("home.jsp").forward(request, response);
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
