package PMS.vo;

public class User {
	private String username;
	private String userpass;
	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.userpass = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return userpass;
	}
	public void setPassword(String password) {
		this.userpass = password;
	}
	
	
}
