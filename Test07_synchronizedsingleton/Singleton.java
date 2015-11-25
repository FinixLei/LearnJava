package Test07_synchronizedsingleton;

public class Singleton {
	public static Singleton getInstance() {
		if (s == null) {
			synchronized(Singleton.class){
				if (s == null){ // This check is important for avoiding another thread to new again
					s = new Singleton();
				}
			}
		}		
		return s;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int v) {
		value = v;
	}
	
	private Singleton(){
		value = 0;
	}
	
	private static Singleton s;
	private int value;
}
