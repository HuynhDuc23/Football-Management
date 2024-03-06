package admincontroller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import admindao.teamDao;
import model.player;
import model.playerTeam;
import model.team;

/**
 * Servlet implementation class selectPlayerServlet
 */
@WebServlet(urlPatterns = { "/selectPlayerServlet", "/admin/selectPlayerServlet" })
public class selectPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public selectPlayerServlet() {
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
		admindao.playerTeam dao = new admindao.playerTeam();
		teamDao dao2 = new teamDao();
		ArrayList<team> getIdTeam = dao2.getID();
		player player = dao.getPlayerById(Integer.parseInt(id));
		System.out.println(player);
		request.setAttribute("getIdTeam", getIdTeam);
		request.setAttribute("player", player);
		request.getRequestDispatcher("updatePlayer.jsp").forward(request, response);

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
