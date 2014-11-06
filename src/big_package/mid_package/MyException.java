package big_package.mid_package;

public class MyException extends Exception {
	public MyException(String errorMessage){
		super(errorMessage);
		System.out.println("My Exception occurs!");
	}
}
