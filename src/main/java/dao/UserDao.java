package dao;

import java.sql.Statement;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class UserDao {
	String INSERT_USERS_SQL = "INSERT INTO user" + "  (uid ,unameig,uname , upass, uemail, urank, uscore) VALUES "
			+ " (?, ?, ?, ?, ?,?,?);";



	public int registerUser(UserDetails user) throws ClassNotFoundException, SQLException {
		int result = 0;
		Class.forName("org.hsqldb.jdbcDriver");

		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/examples", "sa", ""))


		{
			// Step 3: Execute the query or update query
			try {
				Statement statement = connection.createStatement();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			String uName = user.getUserName();
			String uIGName = user.getUserNameIG();
			String uEmail = user.getUserEmail();

			try (PreparedStatement insert = connection.prepareStatement(INSERT_USERS_SQL)) {
				insert.setString(1, user.getUserID());
				insert.setString(2, user.getUserName());
				insert.setString(3, user.getUserNameIG());
				insert.setString(4, user.getUserPassword());
				insert.setString(5, user.getUserEmail());
				insert.setInt(6, user.getUserRank());
				insert.setInt(7, user.getUserScore());
				insert.executeUpdate();
				result = insert.executeUpdate();

			}

		}
		return result;

	}
			

}
