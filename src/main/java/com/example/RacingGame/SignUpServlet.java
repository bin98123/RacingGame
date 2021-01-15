package servlet;

import java.io.IOException;
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
@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String userID = request.getParameter("userID");
		boolean ok = false;
		String userName = request.getParameter("userName");
		String userNameIG = request.getParameter("userNameIG");
		String userID = userName + userNameIG;
		String userPassword = request.getParameter("userPassword");
		String userEmail = request.getParameter("userEmail");
//		String userRank = request.getParameter("userRank");
		int userRank = 0;
		int userScore = 0;
		UserDetails userDetails = new UserDetails();
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
			request.setAttribute("registeredUser", userDao);
			request.setAttribute("passwordError", "You must enter password!!!");
		}
		if ((userName == "")) {
			ok = false;
			request.setAttribute("registeredUser", userDao);
			request.setAttribute("userNameError", "You must enter user name!!!");
		}
		if ((userNameIG == "")) {
			ok = false;
			request.setAttribute("registeredUser", userDao);
			request.setAttribute("userNameIGError", "You must enter user name in game!!!");
		}

		userDetails.setUserID(userID);
		userDetails.setUserName(userName);
		userDetails.setUserNameIG(userNameIG);
		userDetails.setUserPassword(userPassword);
		userDetails.setUserEmail(userEmail);
		userDetails.setUserRank(userRank);
		userDetails.setUserScore(userScore);

		try {
			userDao.registerUser(userDetails);
			if (userDao.registerUser(userDetails) > 0) {
				request.getRequestDispatcher("/WelcomeUser.jsp").forward(request, response);
			} else
				response.sendRedirect("signup.jsp");
//			response.sendRedirect("UserRegistSuccess.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			if (userDao.registerUser(userDetails) == 0) {
//				response.sendRedirect("RegistFail.jsp");
//			} else {

	}

//		} catch (ClassNotFoundException |
//
//				IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
}
//}
