package HelloJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.BigInteger;

import MyReflect.TestReflect;
import big_package.mid_package.*;
import java.util.*;
import java.io.*;

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
		testReflect();
		// testGeneralization();
		// testEnum();
		// testSyncMethod();
		// testSafeRunnable();
		// testRunnable();
		// testThreadTest();
		// testDataInputStreamDataOutputStream();
		// testBufferedReaderBufferedWriter();
		// testFileReaderFileWriter();
		// testFileInputStreamFileOutputStream();
		// testFile();
		// testMap();
		// testTreeSet();
		// testLinkedList();
		// testCollection();
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
	
	private static void testReflect() {
		TestReflect.testConstructor();
	}
	
	private static void testGeneralization(){
		GeneralClass<Integer> g1 = new GeneralClass<Integer>();
		g1.setData(100);
		g1.printData();

		GeneralClass<Float> g2 = new GeneralClass<Float>();
		g2.setData(123.456f);
		g2.printData();
	}
	
	private static void testEnum(){
		MyEnum me = new MyEnum();
		me.listAllColors();
		me.test_1();
	}
	
	private static void testSyncMethod(){
		SyncMethodTest st = new SyncMethodTest(5);
		st.startThreads();
	}
	
	private static void testSafeRunnable() {
		SafeRunnableTest srt = new SafeRunnableTest();
		srt.startThreads();
	}
	
	private static void testRunnable() {
		RunnableTest rt = new RunnableTest();
		rt.startThreads();
	}
	
	private static void testThreadTest(){
		try{
			ThreadTest[] tarray = {new ThreadTest(), new ThreadTest(), new ThreadTest()};
			// ThreadTest[] tarray = new ThreadTest[3]; // This line does not work: new does not work for array
			for(int i=0; i<tarray.length; i++){
				tarray[i].start();
			}
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	private static void testDataInputStreamDataOutputStream(){
		File file = new File("./testDataStream.txt");
		try {
			FileOutputStream fs = new FileOutputStream(file);
			DataOutputStream ds = new DataOutputStream(fs);
			
			ds.writeUTF("Using writeUTF() to write data");
			ds.writeChars("Using writeChars() to write data");
			ds.writeBytes("Using writeBytes() to write data");
			ds.close();
			fs.close();
		} catch(Exception ex) {
			System.out.println("In output part: " + ex.getMessage());
		}
		
		try{
			FileInputStream fis = new FileInputStream(file);
			DataInputStream dis1 = new DataInputStream(fis);
			System.out.println("The file content is: ");
			System.out.print(dis1.readUTF());
			dis1.close();
			fis.close();
			// Display is: 
			// The file content is: 
			// Using writeUTF() to write data
		} catch(Exception ex){
			System.out.println("In input part: " + ex.getMessage());
		}
		
		file.delete();
	}
	
	private static void testBufferedReaderBufferedWriter(){
		String[] content = {
				"你好哇！", 
				"你学习过Java吗？",
				"我正在学习Java！"
		};
		
		File file = new File("testBuffered.txt");
		try{
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufw = new BufferedWriter(fw);
			for (String line : content) {
				bufw.write(line);
				bufw.newLine();
			}
			bufw.flush();
			bufw.close();
			fw.close();
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		
		try{
			FileReader fr = new FileReader(file);
			BufferedReader bufr = new BufferedReader(fr);
			int i = 0;
			String s = null;
			while((s=bufr.readLine()) != null){
				i++;
				System.out.println("第" + i + "行： " + s);
			}
			bufr.close();
			fr.close();
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		
		file.delete();
	}
	
	private static void testFileReaderFileWriter(){
		File file = new File("./testFileReaderFileWriter.txt");
		try{
			FileWriter out = new FileWriter(file);
			String s = "你好，我叫雷！";
			out.write(s);
			out.close();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		try{
			FileReader in = new FileReader(file);
			char array[] = new char[10000];
			int len = in.read(array);
			in.close();
			System.out.println("File content is:");
			System.out.println(new String(array, 0, len));
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		file.delete();
	}
	
	private static void testFileInputStreamFileOutputStream(){
		File file = new File("./testFileStream.txt");
		try {
			FileOutputStream out = new FileOutputStream(file);
			// String s1 = "Hello, I'm learning Java!";
			String s2 = "你好，我正在学习Java！";
			byte array[] = s2.getBytes();
			out.write(array);
			out.close();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		try {
			FileInputStream in = new FileInputStream(file);
			byte array[] = new byte[10000];
			int len = in.read(array);
			System.out.println("The content of file " + file.getName() + " is: ");
			System.out.println(new String(array, 0, len));
			in.close();
						
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		file.delete();
	}
	
	private static void testFile(){
		File file = new File("./myfile.txt");
		if(file.exists()) {
			file.delete();
			System.out.println("deleted file " + file.getName());
		} else {
			try {
				file.createNewFile();
				System.out.println("Created file " + file.getName());
				long len = file.length();
				boolean hidden = file.isHidden();
				System.out.println("File Name: " + file.getName());
				System.out.println("File Length: " + len);
				System.out.println("File is hidden? " + hidden);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			} finally {
				file.delete();
			}
		}
	}
	
	private static void testMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("0001", "Finix");
		map.put("0002", "Bob");
		map.put("0003", "kdfjdk");
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		System.out.println("All the elements in map: ");
		while(it.hasNext()){
			String k = it.next();
			System.out.println(k + ": " + map.get(k));
		}
		
		Collection<String> coll = map.values();
		it = coll.iterator();
		System.out.println("All the elements in values: ");
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		// Create TreeMap from HashMap
		TreeMap<String, String> treemap = new TreeMap<String, String>();
		treemap.putAll(map);
		System.out.println("All the elements in treemap: ");
		it = treemap.keySet().iterator();
		while(it.hasNext()){
			String k = it.next();
			System.out.println(k + ": " + treemap.get(k));
		}
	}
	
	private static void testTreeSet(){
		UpdateStu stu1 = new UpdateStu("Alice", 19876);
		UpdateStu stu2 = new UpdateStu("Bob", 10091);
		UpdateStu stu3 = new UpdateStu("Cooker", 43002);
		UpdateStu stu4 = new UpdateStu("Doglas", 59992);
		UpdateStu stu5 = new UpdateStu("Ema", 9999);
		
		TreeSet<UpdateStu> tree = new TreeSet<UpdateStu>();
		tree.add(stu1);
		tree.add(stu2);
		tree.add(stu3);
		tree.add(stu4);
		tree.add(stu5);
		
		Iterator<UpdateStu> it = tree.iterator();
		System.out.println("All the elements:");
		while(it.hasNext()){
			UpdateStu stu = (UpdateStu) it.next();
			System.out.println(stu.getId() + " " + stu.getName());
		}
		
		System.out.println("Get the first part of students:");
		it = tree.headSet(stu2).iterator();
		while(it.hasNext()){
			UpdateStu stu = (UpdateStu) it.next();
			System.out.println(stu.getId() + " " + stu.getName());
		}
		
		System.out.println("Get the middle part of students:");
		it = tree.subSet(stu2,  stu4).iterator();
		while(it.hasNext()){
			UpdateStu stu = (UpdateStu) it.next();
			System.out.println(stu.getId() + " " + stu.getName());
		}
	}
	
	private static void testLinkedList() {
		List<String> list = new LinkedList<String>();
		list.add("abc");
		list.add("def");
		list.add("hello");
		
		for (String s : list){
			System.out.print(s + ", ");
		}
		System.out.println("");
		int index = (int)(Math.random() * list.size());
		list.remove(index);
		for (String s : list){
			System.out.print(s + ", ");
		}
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
		//	In GenTwo: Do Something!
		
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
		System.out.println(f3.format(0.789)); // 千分之789.00
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
		
		System.out.println("");
		Integer[] b = new Integer[a.length];
		int count = 0;
		for (int i : a) {
			b[count++] = Integer.valueOf(i);
		}
		for (Integer i : b) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		Arrays.sort(b, Collections.reverseOrder());
		for (Integer i : b) {
			System.out.print(i + ", ");
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
		System.out.println("Start to test elapsed time for string and StringBuilder...");
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
		System.out.println("today is " + today);  // today is Wed Aug 12 14:00:00 CST 2015
		
		String f1 = String.format("%tF", today);
		System.out.println("Format-1 is " + f1);  // Format-1 is 2015-08-12
		String f2 = String.format("%tF %tr", today, today);
		System.out.println("Format-2 is " + f2);  // Format-2 is 2015-08-12 02:00:00 PM
		String f3 = String.format("%tF %tT", today, today);
		System.out.println("Format-3 is " + f3);  // Format-2 is 2015-08-12 14:00:00
	}
	
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
