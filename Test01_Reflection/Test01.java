package Test01_Reflection;

public class Test01 {

	public static void main(String[] args) {
		test_reflect_01();
		// test_toString();
	}
	
	private static void test_toString() {
		Employee x = new Employee(100, "Finix");
		System.out.println("" + x);
		System.out.println(x.getClass());
	}
	
	private static void test_reflect_01(){
		// Case 1
		System.out.println("Case 1 --------------------");
		Employee e1 = new Employee(101, "Fox");
		Class c1 = e1.getClass();
		System.out.println(c1.getName() + " " + e1.getName());
		System.out.println("");
		
		// Case 2
		System.out.println("Case 2 --------------------");
		String name1 = "Test01.Employee";
		try {
			Class c2 = Class.forName(name1);
			System.out.println(c2.getName());
		} 
		catch(ClassNotFoundException cnf) {
			System.out.println("Class Not Found: " + cnf.getMessage());
		} 
		finally {
			System.out.println("");
		}
		
		// Case 3
		System.out.println("Case 3 --------------------");
		String name2 = "NoSuchClass";
		try {
			Class c3 = Class.forName(name2);
			System.out.println(c3.getName());
		} 
		catch(ClassNotFoundException cnf) {
			System.out.println("Class Not Found: " + cnf.getMessage());
			cnf.printStackTrace();
		} 
		finally {
			System.out.println("");
		}
		
		// Case 4
		System.out.println("Case 4 --------------------");
		Class c4 = Employee.class;
		System.out.println(c4.getName());
		System.out.println("");
		
		// Case 5
		System.out.println("Case 5 --------------------");
		System.out.println(Double[].class.getName());
		System.out.println(int[].class.getName());
		System.out.println("");
		
		// Case 6: newInstance
		System.out.println("Case 6: newInstance --------------------");
		try {
			Object c6 = Class.forName(name1).newInstance();
			System.out.println("Name is: " + ((Employee)(c6)).getName());
		} 
		catch (ClassNotFoundException ex) {
			System.out.println("Class Not Found: " + ex.getMessage());
		} 
		catch (IllegalAccessException ilae) {
			System.out.println("Illegal Access Exception: " + ilae.getMessage());
		} 
		catch (InstantiationException ie) {
			System.out.println("Instaniation Exception: " + ie.getMessage());
		} 
		finally {
			System.out.println("");
		}
	}

}
