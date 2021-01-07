package dao;

public class UserDetails implements Comparable {
	private String userID = null;
	private String userName = null;
	private String userNameIG = null;
	private String userPassword = null;
	private String userEmail = null;
	private int userRank = 0;
	private int userScore = 0;

	public UserDetails() {
	}

	public UserDetails(String userID, String userName, String userNameIG, String userPassword, String userEmail,
			int userRank, int userScore) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userNameIG = userNameIG;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userRank = userRank;
		this.userScore = userScore;
	}

	@Override
	public int compareTo(Object o) {

		UserDetails n = (UserDetails) o;
		int lastCmp = userName.compareTo(n.userName);
		return (lastCmp);
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserNameIG(String userNameIG) {
		this.userNameIG = userNameIG;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserRank(int userRank) {
		this.userRank = userRank;
	}

	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

	public String getUserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserNameIG() {
		return userNameIG;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public int getUserRank() {
		return userRank;
	}

	public int getUserScore() {
		return userScore;
	}

}