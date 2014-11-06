package big_package.mid_package;

public class UpdateStu implements Comparable<Object> {
	String name;
	long id;
	
	public UpdateStu(String name, long id) {
		this.name = name;
		this.id = id;
	}
	
	public int compareTo(Object o) {
		UpdateStu us = (UpdateStu) o;
		return this.id > us.id ? 1 : (this.id == us.id ? 0 : -1);
	}
	
	public String getName(){
		return this.name;
	}
	
	public long getId(){
		return this.id;
	}
}

