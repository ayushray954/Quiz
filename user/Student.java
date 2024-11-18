package user;

public class Student extends User{
	private String role = "student";
	private int result = 0;
	public Student(String name) {
		super(name);
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String toString() {
		String print = id + "\n" + name + "\nResult : " + result; 
		return print;
	}
}