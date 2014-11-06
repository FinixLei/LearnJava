package HelloJava;

class Parents{
	private final void doIt(){
		System.out.println("Parent's doIt");
	}
	
	final void doIt2(){
		System.out.println("Parent's doIt2");
	}
}

class Son extends Parents {
	public final void doIt(){
		// this is a new method, not over-write doIt() in Parent class. 
		System.out.println("Son's doIt");
	}
	
	// cannot define "final void doIt2()" as it's final. 
}

public class FinalMethod {
	public static void main(String[] args){
		Son s = new Son();
		s.doIt();
		
		Parents p = s;
		// p.doIt(); // cannot call doIt() as it's private
		p.doIt2();
	}
}
