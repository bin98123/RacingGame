package dao;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	String INSERT_USERS_SQL = "INSERT INTO user" + " VALUES " + " (?, ?, ?, ?, ?, ?, ?)";
//	String CHECK_USERS_SQL = "SELECT * FROM user WHERE UNAME = " + "?" + " AND UIGNAME = " + "?" + " AND UEMAIL = "
//			+ "?";
//	String CHECK_USERS_SQL = "SELECT * FROM user WHERE UNAME ='" + "?" + "'" + " AND UIGNAME='" + "?" + "'"
//			+ " AND UEMAIL='" + "?" + "'";

	int result = 0;

	public int registerUser(UserDetails user) throws ClassNotFoundException, SQLException {

		Class.forName("org.hsqldb.jdbcDriver");

		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/sample", "sa", "")) {

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

	public int checkExistUser(UserDetails user) throws ClassNotFoundException, SQLException {

		Class.forName("org.hsqldb.jdbcDriver");

		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/sample", "sa", "")) {
			String CHECK_USERS_SQL = "SELECT * FROM user WHERE UNAME ='" + user.getUserName() + "'" + " OR UIGNAME='"
					+ user.getUserNameIG() + "'" + " OR UEMAIL='" + user.getUserEmail() + "'";
			try (Statement insert = connection.createStatement()) {
//				insert.setString(1, user.getUserID());
//				INSERT.SETSTRING(1, USER.GETUSERNAME());
//				Insert.setString(2, user.getUserNameIG());
//				insert.setString(4, user.getUserPassword());
//				insert.setString(3, user.getUserEmail());
//				insert.setInt(6, user.getUserRank());
//				insert.setInt(7, user.getUserScore());
				Statement statement = connection.createStatement();
//				System.out.println(insert);
				// Step 3: Execute the query or update query
				ResultSet rs = statement.executeQuery(CHECK_USERS_SQL);
				if (rs.next()) {
//					result = insert.executeUpdate();
					result = 1;

				}
				rs.close();
				statement.close();
				connection.close();

			}
			return result;
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(
				new UserDao().checkExistUser(new UserDetails(null, "la", "la", null, "tranhungd264@gmail.com", 0, 0)));
	}

}
