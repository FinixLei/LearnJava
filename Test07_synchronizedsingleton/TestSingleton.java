package Test07_synchronizedsingleton;

import java.util.List;
import java.util.ArrayList;

public class TestSingleton {

	public static void main(String[] args) {
		final int size = 10;
		List<Thread> array = new ArrayList<Thread>(size);
		
		for (int i=0; i<size; i++) {
			array.add(new Thread(new Runnable() {
				public void run() {
					Singleton myInstance = Singleton.getInstance();
					synchronized(Singleton.class) {
						myInstance.setValue(myInstance.getValue() + 1);
						System.out.println("value = " + myInstance.getValue());
					}
				}
			}));
		}
		
		for (int i=0; i<array.size(); i++) {
			array.get(i).start();
		}
	}
}

