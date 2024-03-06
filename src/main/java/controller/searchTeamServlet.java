package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import dao.teamDao;
import model.team;

/**
 * Servlet implementation class searchTeamServlet
 */
@WebServlet("/searchTeamServlet")
public class searchTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchTeamServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search = request.getParameter("search");
		String index1 = request.getParameter("index");
		teamDao dao = new teamDao();
		if (dao.countTeamSearch(search) < 1) {
			request.getRequestDispatcher("HomeServletHeader").forward(request, response);
		} else {
			request.getSession().setAttribute("search", search);
			if (index1 == null) {
				index1 = "1";
			}
			int index = 0;
			int count = 0;
			int endPage = 0;
			if (search != null) {
				if (dao.countTeamSearch(search) > 0) {
					count = dao.countTeamSearch(search);
					// count team search
					ArrayList<team> arr = dao.getAllTeamPaging(search, Integer.parseInt(index1));
					endPage = count / 3;
					if (count % 3 != 0) {
						endPage++;
					}
					request.setAttribute("tag", (Integer.parseInt(index1)));
					request.setAttribute("paging", endPage);
					request.setAttribute("pagingTeam", arr);
					request.getRequestDispatcher("homepaging2.jsp").forward(request, response);
				}
			}
		}
	}
}
