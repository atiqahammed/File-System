package Authentication;

public class User {
	private String userName;
	private String email;
	private String password;

	public User(String un, String em, String ps) {
		userName = un;
		email = em;
		password = ps;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}