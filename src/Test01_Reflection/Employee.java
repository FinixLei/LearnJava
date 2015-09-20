package Test01_Reflection;

public class Employee {
	private int id;
	private String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Employee() {
		this.id = -1;
		this.name = "Unknown";
	}
	
	public String toString() {
		return this.id + " " + this.name;
	}
	
	public String getName(){
		return this.name;
	}
}
