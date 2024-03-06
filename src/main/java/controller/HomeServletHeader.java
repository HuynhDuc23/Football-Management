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
 * Servlet implementation class HomeServletHeader
 */
@WebServlet("/HomeServletHeader")
public class HomeServletHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServletHeader() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String session = (String) request.getSession().getAttribute("session");
		teamDao dao = new teamDao();
		ArrayList<team> getAllTeamSession = dao.getTopByIdSession(Integer.parseInt(session));
		matchDao matchDao = new matchDao();
		ArrayList<match> getAllMatchSession = matchDao.getAllMatchSession(Integer.parseInt(session));
		request.setAttribute("matchSession", getAllMatchSession);
		request.setAttribute("team", getAllTeamSession);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
