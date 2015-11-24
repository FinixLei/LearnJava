package HelloJava;

public class MyEnum {
	enum Color {
		Green, Blue, Red, Yellow, White, Black, Gray
	}
	
	public void listAllColors(){
		for(int i=0; i<MyEnum.Color.values().length; i++){
			System.out.println(MyEnum.Color.values()[i] + ", index = " + MyEnum.Color.values()[i].ordinal());
		}	
	}
	
	public void test_1(){
		String s = "Blue";
		if(Color.Blue == Color.valueOf(s)) {
			System.out.println("They are the same.");
		} else {
			System.out.println("They are different.");
		}
	}
}
