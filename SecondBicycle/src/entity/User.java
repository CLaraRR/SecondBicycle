package entity;

public class User {
	private String username;
	private String password;
	private String phone;
	private String email;
	private String address;
	
	public User() {
		super();
	}

	public User(String username, String password,String phone,String email,String address) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String usrname) {
		this.username = usrname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
