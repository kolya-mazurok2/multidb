package com.stud.multidb.model;

public class User {
	private Integer id;
	private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public long getId() {
		return id;
	}
    
	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {}
	
	public User(int id) {
		this.id = id;
	}
    
    public User(int id, String login, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                	"User[id=%d, login='%s', firstName='%s', lastName='%s', email='%s', password='%s']",
                id, login, firstName, lastName, email, password);
    }
}
