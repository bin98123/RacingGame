package dao;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class UserDao {
	String INSERT_USERS_SQL = "INSERT INTO user" + " VALUES " + " (?, ?, ?, ?, ?, ?, ?)";

	int result = 0;

	public int registerUser(UserDetails user) throws ClassNotFoundException, SQLException {

		Class.forName("org.hsqldb.jdbcDriver");

		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/sample", "sa", ""))

		{

			try (PreparedStatement insert = connection.prepareStatement(INSERT_USERS_SQL)) {
				insert.setString(1, user.getUserID());
				insert.setString(2, user.getUserName());
				insert.setString(3, user.getUserNameIG());
				insert.setString(4, user.getUserPassword());
				insert.setString(5, user.getUserEmail());
				insert.setInt(6, user.getUserRank());
				insert.setInt(7, user.getUserScore());
				Statement statement = connection.createStatement();
				System.out.println(insert);
				// Step 3: Execute the query or update query
				result = insert.executeUpdate();
				statement.close();
				connection.close();

			}
			return result;
		}
	}

}
