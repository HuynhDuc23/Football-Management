package authen;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.account;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public LoginFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String url = req.getServletPath();
		// // Trả về sau tên project
		// // trong authorization có 2 trường hợp
		// // 1 chưa đăng nhập -> truy cập link
		// // 2 đăng nhập nhưng là user không có quyền vô admin ;
		       HttpSession seasion = req.getSession();
		// // Kiểm Tra Đăng Nhập Hoặc chưa
		if ((seasion.getAttribute("Account") != null) || url.equals("/validateFormServlet")) {
			account acc = (account) seasion.getAttribute("Account");
			if (url.startsWith("/admin")) {
				if (acc.getRole() == 1) {
					chain.doFilter(request, response);
				} else {
					req.getRequestDispatcher("error/e404.jsp").forward(request, response);

				}
			} else {
				chain.doFilter(request, response);
			}
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
