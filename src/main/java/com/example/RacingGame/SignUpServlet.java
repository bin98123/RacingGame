package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDetails;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean ok = true;
		String userName = request.getParameter("userName");
		String userNameIG = request.getParameter("userNameIG");
		String userID = userName + userNameIG;
		String userPassword = request.getParameter("userPassword");
		String userEmail = request.getParameter("userEmail");
		int userRank = 0;
		int userScore = 0;
		UserDetails userDetails = new UserDetails();
		userDetails.setUserID(userID);
		userDetails.setUserName(userName);
		userDetails.setUserNameIG(userNameIG);
		userDetails.setUserPassword(userPassword);
		userDetails.setUserEmail(userEmail);
		userDetails.setUserRank(userRank);
		userDetails.setUserScore(userScore);
		userDetails = new UserDetails(userID, userName, userNameIG, userPassword, userEmail, userRank, userScore);
		if ((userEmail == "")) {
			ok = false;
			request.setAttribute("registeredUser", userDetails);
			request.setAttribute("emailError", "You must enter email!!!");

		}
		Pattern mailPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)*");
		Matcher mailMatcher = mailPattern.matcher((CharSequence) userEmail);
		if (!mailMatcher.matches()) {
			ok = false;
			request.setAttribute("emailError", "Error pattern email!!!");
		}
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
		if ((userNameIG == "")) {
			ok = false;
			request.setAttribute("registeredUser", userDetails);
			request.setAttribute("nameIGError", "You must enter user name in game!!!");
		}

		try {
			UserDao userDao = new UserDao();
			if (ok == true && userDao.registerUser(userDetails) != 0) {
				response.sendRedirect("/Project/WelcomeUser.jsp");

			} else {
				request.setAttribute("registeredUser", userDetails);
//				giữ các giá trị của userDetails khi forward tới trang signup.jsp
				getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);

			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
