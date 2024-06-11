package model;

public class User {
	private int id;
	private String name;
	private String email;
	
	public User() {}
	
	public User(int id, String name, String email) {
		
		setId(id);
		setName(name);
		setEmail(email);
	}
	
	public User(String name, String email) {
		
		setName(name);
		setEmail(email);
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
