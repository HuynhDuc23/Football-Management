package admincontroller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import admindao.teamDao;
import dao.matchDetailsServletDao;
import model.matchDetailTeam;

/**
 * Servlet implementation class updateMatchDetailsServlet
 */
@WebServlet(urlPatterns = { "/updateMatchDetailsServlet", "/admin/updateMatchDetailsServlet" })
public class updateMatchDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateMatchDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("update")) {
			String idMatchDetail = request.getParameter("idMatch");
			System.out.println(idMatchDetail);
			String score = request.getParameter("score");
			matchDetailsServletDao t = new matchDetailsServletDao();
			System.out.println(t.updateMatchDetail(Integer.parseInt(idMatchDetail), Integer.parseInt(score)));
			matchDetailTeam matchDetailTeam = t.getMatchDetail(Integer.parseInt(idMatchDetail));
			request.setAttribute("matchDetailTeam",matchDetailTeam);
			request.getRequestDispatcher("updateMatchDetailTeam.jsp").forward(request, response);
			
		}else if(action.equals("read")) {
			String id = request.getParameter("id");
			matchDetailsServletDao dao = new matchDetailsServletDao();
			matchDetailTeam t = dao.getMatchDetail(Integer.parseInt(id));
			request.setAttribute("matchDetailTeam",t);
			request.getRequestDispatcher("updateMatchDetailTeam.jsp").forward(request, response);
			
		}

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
