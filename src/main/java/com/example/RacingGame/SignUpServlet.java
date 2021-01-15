package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDetails;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/SigInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
//	public SignInServlet() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doPost(request, response);
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean ok = true;
		UserDetails userDetails = new UserDetails();
//		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		userDetails.setUserName(userName);
		userDetails.setUserPassword(userPassword);
		userDetails = new UserDetails(null, userName, null, userPassword, null, 0, 0);
		if ((userPassword == "")) {
			ok = false;
			request.setAttribute("registeredUser", userDetails);
			request.setAttribute("passwordError", "You must enter password!!!");
		}
		if (userName == "") {
			ok = false;
			request.setAttribute("registeredUser", userDetails);
			request.setAttribute("userNameError", "You must enter user name!!!");
		}
		try {

			if (ok == true) {
				try {
					Class.forName("org.hsqldb.jdbcDriver");

					Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/sample", "sa", "");

					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(
							"select uname,upass from user where uname='" + userName + "' and upass='" + userPassword + "'");

					if (rs.next()) {
//					response.sendRedirect(
//							"http://localhost:8080/RacingGame/WelcomeUser.jsp?name=" + rs.getString("uname"));
//
//					HttpSession session = request.getSession();
//					session.setAttribute("uname", uname);
//						request.getRequestDispatcher("/RacingGame/WelcomeUser.jsp").forward(request, response);
						request.getRequestDispatcher("/WelcomeUser.jsp").forward(request, response);

					} else {

						if (!rs.next()) {
//					HttpSession session = request.getSession();
//					response.sendRedirect("http://localhost:8080/RacingGame/Regagain.jsp");
							request.setAttribute("registeredUser", userDetails);
//							request.getRequestDispatcher("/RacingGame/login.jsp").forward(request, response);
							getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

						}
					}
				} catch (

						Exception ex) {
					System.out.println("Exception in UserProfile: " + ex);

				}
			} else {
				request.setAttribute("registeredUser", userDetails);
//				request.getRequestDispatcher("/RacingGame/login.jsp").forward(request, response);
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in UserProfile: " + e);
		}

	}
}