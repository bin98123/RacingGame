package com.example.RacingGame;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfileDAO;
import dao.ProfileUser;
import dao.UserDetails;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProfileDAO dao = new ProfileDAO();
		String nameImg = null;
		ProfileUser profile = new ProfileUser();
		profile.setPhoto(nameImg);
		dao.findPic();
		UserDetails userDetails = new UserDetails(null, "exist", null, null, null, 0, 0);
		String path = dao.findPic();
		request.setAttribute("pic", path);
		request.setAttribute("LIST_INFO", dao.getAll());
		request.setAttribute("registeredUser", userDetails);
		request.setAttribute("namePic", nameImg);

		getServletContext().getRequestDispatcher("/WelcomeUser.jsp").forward(request, response);
	}
}
