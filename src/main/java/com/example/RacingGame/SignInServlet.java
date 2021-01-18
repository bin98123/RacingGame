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

import dao.ProfileDAO;
import dao.UserDao;
import dao.UserDetails;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/SigInServlet")
public class SignInServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        boolean ok = true;

        UserDetails userDetails = new UserDetails();
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
                    ResultSet rs = stmt.executeQuery("select uid,uname,upass from user where uname='" + userName
                            + "' and upass='" + userPassword + "'");

                    if (rs.next()) {
                        ProfileDAO dao = new ProfileDAO();
                        dao.findPic();
                        String pathAvatar = dao.findPic();
                        request.setAttribute("pic", pathAvatar);
                        request.setAttribute("registeredUser", userDetails);
                        request.getRequestDispatcher("/WelcomeUser.jsp").forward(request, response);

                    } else {

                        if (!rs.next()) {

                            request.setAttribute("registeredUser", userDetails);
                            getServletContext().getRequestDispatcher("/loginError.jsp").forward(request, response);

                        }
                    }
                } catch (

                        Exception ex) {
                    System.out.println("Exception in UserProfile: " + ex);

                }
            } else {
                request.setAttribute("registeredUser", userDetails);
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

            }
        } catch (Exception e) {
            System.out.println("Exception in UserProfile: " + e);
        }

    }

}