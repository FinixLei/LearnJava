package HelloJava;

interface intf1{
	void printData(int data);
}

interface intf2 extends intf1 {
	void printDataMore(int data);
}

class GenTwo extends GenOne 
			 implements intf2 {
	public GenTwo(){
		super();
		super.doSomething();
		System.out.println("In GenTwo - Constructor");
	}
	
	public void doSomething(){
		// the return type can be public although the return type is protected in GenOne's doSomthing,
		// but the return type cannot be changed to private. 
		System.out.println("In GenTwo: Do Somthing!");
	}
	
	public GenTwo doIt(){
		// It can return GenTwo type as the function doIt() in GenOne return GenOne type
		return new GenTwo();
	}
	
	public static void main(String[] args){
		GenTwo g2_1 = new GenTwo();
		GenTwo g2_2 = g2_1.doIt();
		g2_2.doSomething();
	}
	
	public String toString(){
		return "Rewrite toString() in : " + getClass().getName();
	}
	
	public void printData(int data){
		System.out.println("Data is " + data);
	}
	
	public void printDataMore(int data) {
		System.out.println("More data is " + data);
	}

}
