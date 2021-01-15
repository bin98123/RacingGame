package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/LoginServlet")
public  class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		try {
			Class.forName("org.hsqldb.jdbcDriver");

			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/examples", "sa", "");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select uname,upass from user where uname='" + uname + "' and upass='" + upass + "'");

			if (rs.next()) {
				response.sendRedirect("http://localhost:8080/RacingGame/WelcomeUser.jsp?name=" + rs.getString("uname"));

				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);

			} else if (!rs.next()) {
				response.sendRedirect("http://localhost:8080/RacingGame/Regagain.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);

			} else {
				out.println();
				out.println("User Name or Password not Matched");
			}

		} catch (Exception ex) {
			System.out.println("Exception in UserProfile: " + ex);


		}

	}
}