package HelloJava;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class GeneralClass<T> {
	private T data;

	public void setData(T d){
		data = d;
	}
	
	public String toString(){
		return "data is: " + data;
	}
	
	protected void printData(){
		System.out.println(data.toString());
	}
	
}
