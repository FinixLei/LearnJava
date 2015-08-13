package Test01;

class Employee {
	private int id;
	private String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String toString() {
		return this.id + " " + this.name;
	}
}

public class Test01 {

	public static void main(String[] args) {
		test_toString();

	}
	
	private static void test_toString() {
		Employee x = new Employee(100, "Finix");
		System.out.println("" + x);
		System.out.println(x.getClass());
	}

}
