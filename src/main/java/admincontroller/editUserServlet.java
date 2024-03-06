package admincontroller;

import java.io.IOException;
import java.nio.file.Path;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import admindao.userDao;
import model.account;

/**
 * Servlet implementation class editUserServlet
 */
@MultipartConfig
@WebServlet(urlPatterns = { "/editUserServlet", "/admin/editUserServlet" })

public class editUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editUserServlet() {
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
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		Part part = (Part) request.getPart("file");

		String fileName = "";
		// Lấy đường dẫn gốc muốn lưu
		String realPath = "C:\\Users\\ACER\\eclipse-workspace\\Projectjava-web\\src\\main\\webapp\\imgs\\user";
		try {
			fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		userDao dao = new userDao();
		if (fileName.equals("")) {
			dao.updateUserById(Integer.parseInt(id), name, Integer.parseInt(age), fileName);
		} else {
			part.write(realPath + "/" + fileName);
			String url = "imgs/user/" + fileName;
			dao.updateUserById(Integer.parseInt(id), name, Integer.parseInt(age), url);

		}
		response.sendRedirect("adminuserServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
