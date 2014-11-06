package big_package.mid_package;

import static java.lang.Math.PI;
import static java.lang.System.out;

public class Person {
	private String id;
	private String name;
	
	public Person(){
		this.id = "";
		this.name = "";
	}
		
	public Person(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public String toString(){
		return "id: " + this.id + "\nname: " + this.name;
	}
	
	public void testImportStatic(){
		out.println(PI);
	}
}
