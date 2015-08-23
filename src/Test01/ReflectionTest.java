package Test01;

import java.util.*;
import java.lang.reflect.*;

/**
 * This program uses reflection to print all features of a class
 * @version 1.0 2015-08-23
 * @author Finix
 */

public class ReflectionTest {
	public static void main(String[] args) {
		// read class name from command line args or user input
		String name;
		if (args.length >0) {
			name = args[0];
		} else {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name: ");
			name = in.next();
		}
		
		try {
			// print class name and super class name 
			Class cl = Class.forName(name);
			Class supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if (modifiers.length() > 0) 
				System.out.print(modifiers + " ");
			System.out.println("class " + name);
			
			if (supercl != null && supercl != Object.class) {
				System.out.print(" extends " + supercl.getName());
			}
			
			System.out.print("\n {\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
			System.out.println("}");
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		System.exit(0);
	}
	
	public static void printConstructors(Class cl) {
		Constructor[] constructors = cl.getDeclaredConstructors();
		
		for (Constructor c : constructors) {
			String name = c.getName();
			System.out.print("    ");
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print(name + "(");
			
			// print parameter types
			Class[] paramTypes = c.getParameterTypes();
			for (int j=0; j<paramTypes.length; j++) {
				if (j > 0) {
					System.out.print(", ");
					System.out.print(paramTypes[j].getName());
				}
			}
			System.out.println(");");
		}
	}
	
	public static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();
		
		for (Method m : methods) {
			Class retType = m.getReturnType();
			String name = m.getName();
			
			System.out.print("    ");
			// print modifiers, return type, and method name
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print(retType.getName() + " " + name + "(");
			
			// print parameter types
			Class[] paramTypes = m.getParameterTypes();
			for (int j=0; j<paramTypes.length; j++) {
				if (j > 0) {
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	public static void printFields(Class cl) {
		Field[] fields = cl.getDeclaredFields();
		
		for (Field f : fields) {
			Class type = f.getType();
			String name = f.getName();
			System.out.print("    ");
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.println(type.getName() + " " + name + ";");
		}
	}	
}

/*
Enter class name: 
java.lang.Double
public final class java.lang.Double
 extends java.lang.Number
 {
    public java.lang.Double();
    public java.lang.Double();

    public boolean equals(java.lang.Object);
    public static java.lang.String toString(double);
    public java.lang.String toString();
    public int hashCode();
    public static int hashCode(double);
    public static double min(double, double);
    public static double max(double, double);
    public static native long doubleToRawLongBits(double);
    public static long doubleToLongBits(double);
    public static native double longBitsToDouble(long);
    public volatile int compareTo(java.lang.Object);
    public int compareTo(java.lang.Double);
    public byte byteValue();
    public short shortValue();
    public int intValue();
    public long longValue();
    public float floatValue();
    public double doubleValue();
    public static java.lang.Double valueOf(java.lang.String);
    public static java.lang.Double valueOf(double);
    public static java.lang.String toHexString(double);
    public static int compare(double, double);
    public static boolean isNaN(double);
    public boolean isNaN();
    public static boolean isFinite(double);
    public static boolean isInfinite(double);
    public boolean isInfinite();
    public static double sum(double, double);
    public static double parseDouble(java.lang.String);

    public static final double POSITIVE_INFINITY;
    public static final double NEGATIVE_INFINITY;
    public static final double NaN;
    public static final double MAX_VALUE;
    public static final double MIN_NORMAL;
    public static final double MIN_VALUE;
    public static final int MAX_EXPONENT;
    public static final int MIN_EXPONENT;
    public static final int SIZE;
    public static final int BYTES;
    public static final java.lang.Class TYPE;
    private final double value;
    private static final long serialVersionUID;
}

*/
