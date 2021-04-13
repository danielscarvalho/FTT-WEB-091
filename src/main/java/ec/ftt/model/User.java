package ec.ftt.model;

import java.util.Objects;

//JavaBean
//POJO

public class User {

	private long id;
	private String name,
	               email,
	               color;
	
	public User() {
		
	}
	public User(String id, String name, String email, String color) {
		super();
		setId(id);
		setName(name);
		setEmail(email);
		setColor(color);
	}
	
	public User(long id, String name, String email, String color) {
		super();
		setId(id);
		setName(name);
		setEmail(email);
		setColor(color);
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		
		if (id.length()==0)
			setId(0);
		else
			setId(Long.valueOf(id));
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(color, other.color) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name);
	}
	
	
	
	
}
