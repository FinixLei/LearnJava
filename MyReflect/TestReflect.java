package MyReflect;

import java.lang.reflect.*;

public class TestReflect {
	public static void testConstructor(){
		SampleForReflect sr = new SampleForReflect("Hello, Java", 100);
		Class src = sr.getClass();
		Constructor[] declaredConstructors = src.getDeclaredConstructors();
		
		for (int i=0; i<declaredConstructors.length; i++) {
			Constructor constructor = declaredConstructors[i];
			System.out.println("Check if it is allowed to take var args: " + constructor.isVarArgs());
			
			Class[] parameterTypes = constructor.getParameterTypes();
			for (int j=0; j<parameterTypes.length; j++) {
				System.out.println("" + parameterTypes[j]);
			}
			
			System.out.println("Possible Exception Types: ");
			Class[] exceptionTypes = constructor.getExceptionTypes();
			for(Class cls : exceptionTypes){
				System.out.println("" + cls);
			}
		
			SampleForReflect sr2 = null;
			while(sr2 == null) {
				try {
					if(i==2){
						sr2 = (SampleForReflect) constructor.newInstance();
					} else if(i==1) {
						sr2 = (SampleForReflect) constructor.newInstance("Hi", 200);
					} else {
						Object[] parameters = new Object[] {
								new String[] {"9", "99", "999"}
						};
						sr2 = (SampleForReflect) constructor.newInstance(parameters);
					}
				} catch(Exception ex) {
					System.out.println("When creating instance, throws exception, then do setAccessible() below");
					constructor.setAccessible(true);
				}
			}
			sr2.print();
			System.out.println();
		}
	}
}
