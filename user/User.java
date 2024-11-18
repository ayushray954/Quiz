package user;

import java.time.LocalDateTime;

public class User {
	protected String id = null;
	protected String name = "Unknown";
	public User(String name) {
		this.id = "User-" + LocalDateTime.now();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
