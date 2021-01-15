package servlet;

import java.io.IOException;

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
		String userName = request.getParameter("userName");
		String userNameIG = request.getParameter("userNameIG");
		String userID = userName + userNameIG;
		String userPassword = request.getParameter("userPassword");
		String userEmail = request.getParameter("userEmail");
//		String userRank = request.getParameter("userRank");
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

		try {
			userDao.registerUser(userDetails);
			if (userDao.registerUser(userDetails) > 0) {
				request.getRequestDispatcher("/WelcomeUser.jsp").forward(request, response);
			} else
				response.sendRedirect("RegistFail.jsp");
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
