package admincontroller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import admindao.playerTeam;

/**
 * Servlet implementation class updatePlayerServlet
 */
@WebServlet(urlPatterns = { "/updatePlayerServlet", "/admin/updatePlayerServlet" })
public class updatePlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updatePlayerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String namePlayer = request.getParameter("nameplayer");
		String shirt = request.getParameter("shirt");
		String idTeamList = request.getParameter("idTeamList");
		playerTeam dao = new playerTeam();
		dao.updatePlayerById(Integer.parseInt(id), namePlayer, Integer.parseInt(shirt), Integer.parseInt(idTeamList));
		response.sendRedirect("crudPlayerServlet");
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
