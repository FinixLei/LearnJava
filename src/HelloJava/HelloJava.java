package HelloJava;

import java.util.Arrays;
import java.util.Date;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.BigInteger;
import big_package.mid_package.Person;
import big_package.mid_package.MyException;
import java.util.Random;
import java.util.*;

interface OutInterface{}

class OuterClass{
	public OutInterface doit(final String x) {
		class InnerClass implements OutInterface{
			InnerClass(String s){
				s = x;
				System.out.println(s);
			}
		}
		return new InnerClass("doit");
	}
}

public class HelloJava {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testCollection();
		// testException(10);
		// testLocalInnerClass();
		// testFinalVar(100);
		// testRandom();
		// testImportStatic();
		// testOutPackage();
		// testInterface();
		// System.out.println(testVarLengthFunc(1, 2, 3, 4, 5));
		// testClass_1();
		// testBigInteger();
		// testDecimalFormat();
		// testArraysBinarySearch();
		// testArraysSort();
		// testArray2();
		// testElasedTime();
		// testRE();
		// testDate();
		// testCompareStr();
		// simpleTest();	
	}
	
	private static void testCollection(){
		Collection<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String str = (String)it.next();
			System.out.println(str);
		}
	}
	
	private static void testException(int data){
		try{
			if (data > 0){
				throw new MyException("Data is too big, i.e. greater than 0");
			}
		} catch(MyException me){
			System.out.println(me.getMessage());
			System.out.println(me.getStackTrace());
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
		} finally{
			System.out.println("Got here! Ends!");
		}
	}
	
	private static void testLocalInnerClass() {
		OuterClass oc = new OuterClass();
		oc.doit("Hello, Local Inner Class!");
	}
	
	private static void testFinalVar(final int value){
		// value = value + 10; // Wrong, value cannot be changed.
		System.out.println("value is " + value);
	}
	
	private static void testRandom(){
		Random rand = new Random();
		int a1 = rand.nextInt(100);
		double d1 = rand.nextDouble() * 10;
		System.out.println("rand int is " + a1);
		System.out.println("rand double is " + d1);
	}
	
	private static void testImportStatic(){
		Person xiao_hong = new Person("123", "xiao-hong");
		xiao_hong.testImportStatic();		
	}
	
	private static void testOutPackage(){
		Person xiaoming = new Person("12345", "Huang Xiaoming");
		System.out.println(xiaoming);
	}
	
	private static void testInterface(){
		GenTwo g2 = new GenTwo();
		g2.printData(100);
		g2.printDataMore(200);
	}
	
	private static int testVarLengthFunc(int...array){
		int sum = 0;
		for(int i=0; i<array.length; i++){
			sum += array[i];
		}
		return sum;
	}
	
	private static void testClass_1(){
		GenTwo g2_1 = new GenTwo();
		System.out.println("---------------");
		GenTwo g2_2 = g2_1.doIt();
		System.out.println("---------------");
		g2_2.doSomething();
		
		//	In GenOne Constructor
		//	In GenOne: do something!
		//	In GenTwo - Constructor
		//	---------------
		//	In GenOne Constructor
		//	In GenOne: do something!
		//	In GenTwo - Constructor
		//	---------------
		//	In GenTwo: Do Somthing!
		
		System.out.println(g2_2); 
		g2_2.setData(10);
		g2_1.setData(100);
		System.out.println(g2_2.equals(g2_1)); // false
		g2_1.setData(10);
		System.out.println(g2_2.equals(g2_1)); // true
		
		System.out.println("~~~~~~~~~~~~~");
		GenOne g2_3 = new GenTwo();
		System.out.println(g2_3); 
		
		System.out.println("~~~~~~~~~~~~~");
		System.out.println(g2_3 instanceof GenOne); // true
		System.out.println(g2_3 instanceof GenTwo); // true
		
		GenOne g1_1 = new GenOne();
		if(g1_1 instanceof GenTwo) {
			System.out.println("g1_1 is instance of GenTwo");
			GenTwo g2_4 = (GenTwo)g1_1;
			g2_4.setData(100);
			System.out.println(g2_4.getData());
		} else {
			System.out.println("g1_1 is not instance of GenTwo");
		}

	}
	
	private static void testBigInteger(){
		BigInteger a = new BigInteger("1001");
		BigInteger b = new BigInteger("1000");
		BigInteger result = a.add(b);
		System.out.println("Add Result is " + result);
		result = result.add(new BigInteger("2000"));
		System.out.println("Add Result is " + result);
		
		BigDecimal d = new BigDecimal("100.10302309");
		BigDecimal e = new BigDecimal("9399.12003");
		BigDecimal multi = d.multiply(e);
		System.out.println("Multiple Result is " + multi);
	}
	
	private static void testDecimalFormat(){
		DecimalFormat f1 = new DecimalFormat("###,###.###");
		System.out.println(f1.format(1233456.789)); // 1,233,456.789
		
		DecimalFormat f2 = new DecimalFormat("00000000.###kg");
		System.out.println(f2.format(1234566.789)); // 01234566.789kg
		
		DecimalFormat f3 = new DecimalFormat("000000.000");
		System.out.println(f1.format(123.89)); // 123.89
		
		f1.applyPattern("#.###%");
		System.out.println(f1.format(0.789)); // 78.9%
		
		f2.applyPattern("###.##");
		System.out.println(f2.format(123456.789)); // 123456.79
		
		f3.applyPattern("0.00\u2030");
		System.out.println(f3.format(0.789)); // Ç§·ÖÖ®789.00
	}
	
	private static void testArraysBinarySearch(){
		int[] arr = {10, 4, 25};
		Arrays.sort(arr);
		for (int item : arr){
			System.out.print(item + ", ");
		}
		System.out.println("");
		
		int index; // if not found, the return value is (-insertion_point - 1)
		index = Arrays.binarySearch(arr, 0, 1, 300);
		System.out.println("Index is " + index); // -2
		index = Arrays.binarySearch(arr, 0, 1, 1);
		System.out.println("Index is " + index); // -1
		index = Arrays.binarySearch(arr, 0, 1, 8);
		System.out.println("Index is " + index); // -2
		System.out.println("---------------");
		index = Arrays.binarySearch(arr, 1);
		System.out.println("Index is " + index); // -1
		index = Arrays.binarySearch(arr, 8);
		System.out.println("Index is " + index); // -2
		index = Arrays.binarySearch(arr, 30);
		System.out.println("Index is " + index); // -4
	}
	
	private static void testArraysSort(){
		int a[] = {10, 5, 90, 20, 45};
		for (int item : a){
			System.out.print(item + ", ");
		}
		System.out.println("");
		Arrays.sort(a);
		for(int item : a){
			System.out.print(item + ", ");
		}
	}
	
	private static void testArray2(){
		int arr2[][] = {{4,3}, {2,1}};
		for(int x[] : arr2){
			// System.out.println("x.length = " + x.length);
			for(int e : x) {
				System.out.print(e+", ");
			}
		}
	}
	
	private static void testElasedTime(){
		String str = "";
		long start = System.currentTimeMillis();
		for(int i=0; i<100000; i++){
			str += i;
		}
		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.println("Elased Time for string is " + duration);
		
		StringBuilder strbld = new StringBuilder("");
		start = System.currentTimeMillis();
		for(int i=0; i<100000; i++){
			strbld.append(i);
		}
		end = System.currentTimeMillis();
		duration = end - start;
		System.out.println("Elased Time for StringBuilder is " + duration);
	}
	
	private static void testRE(){
		String rex = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
		String str1 = "aaa@";
		String str2 = "aaaaa";
		String str3 = "1111@111ff.com.cn";
		
		if(str1.matches(rex)){
			System.out.println(str1 + " is a valid email address.");
		} else {
			System.out.println(str1 + " is an invalid email address.");
		}
		
		if(str2.matches(rex)){
			System.out.println(str2 + " is a valid email address.");
		} else {
			System.out.println(str2 + " is an invalid email address.");
		}
		
		if(str3.matches(rex)){
			System.out.println(str3 + " is a valid email address.");
		} else {
			System.out.println(str3 + " is an invalid email address.");
		}
	}
	
	private static void testDate(){
		Date today = new Date();
		System.out.println("today is " + today);
		
		String f1 = String.format("%tF", today);
		System.out.println("Format-1 is " + f1);
		String f2 = String.format("%tF %tr", today, today);
		System.out.println("Format-2 is " + f2);
		String f3 = String.format("%tF %tT", today, today);
		System.out.println("Format-3 is " + f3);
	}
;	
	private static void testCompareStr(){
		String s1 = "ab";
		String s2 = "dega";
		System.out.println("Compare " + s1 + " to " + s2 + " = " + s1.compareTo(s2));
	}
	
	private static void simpleTest(){
		char ch = '@';
		System.out.println("@ is " + (int)ch);
		System.out.println("unicode pos 2605 is " + '\u2605');
		// char c1 = "\\"; // Wrong: c1 is char, "//" is String. 
		char c2 = '\\';
		System.out.println("c2 = " + c2);
	}

}
