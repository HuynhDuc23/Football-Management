package admincontroller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import admindao.playerTeam;
import admindao.teamDao;

/**
 * Servlet implementation class crudPlayerServlet
 */
@WebServlet(urlPatterns = { "/crudPlayerServlet", "/admin/crudPlayerServlet" })
public class crudPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public crudPlayerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		playerTeam play = new playerTeam();
		ArrayList<model.playerTeam> arrPlayer = play.getAlLPlayerTeam();
		request.setAttribute("arrPlayer", arrPlayer);
		teamDao dao = new teamDao();
		ArrayList<model.team> getid = dao.getID();
		request.setAttribute("getid", getid);
		request.getRequestDispatcher("crudPlayer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
