package Test05_Cloneable;

public class TestCloneable {
    private static void test_01() {
        Car car = new Car("Ford", CarColor.WHITE);
        MyInstance mi = new MyInstance("Finix", 80, car);
        
        try {
            MyInstance copy_mi = mi.clone();
            System.out.println(mi);       // MyInstance [name=Finix, age=80, car=Car->[name=Ford, color=WHITE]]
            System.out.println(copy_mi);  // MyInstance [name=Finix, age=80, car=Car->[name=Ford, color=WHITE]]
            
            mi.setName("Knife");
            mi.setAge(99);
            mi.getCar().setColor(CarColor.BLUE);
            System.out.println(mi);       // MyInstance [name=Knife, age=99, car=Car->[name=Ford, color=BLUE]]
            
            // Color is changed, so Object.clone() is Shallow copy.
            System.out.println(copy_mi);  // MyInstance [name=Finix, age=80, car=Car->[name=Ford, color=BLUE]]
            System.out.println();
            
        } catch (CloneNotSupportedException ce) {
            System.out.println("CloneNotSupportedException: " + ce.getMessage());
        }
    }
    
    private static void test_02() {
        Car car = new Car("Ford", CarColor.WHITE);
        MyInstance2 mi2 = new MyInstance2("Finix", 80, car);
        
        try {
            MyInstance2 copy_mi2 = mi2.clone();
            System.out.println(mi2);       // MyInstance [name=Finix, age=80, car=Car->[name=Ford, color=WHITE]]
            System.out.println(copy_mi2);  // MyInstance [name=Finix, age=80, car=Car->[name=Ford, color=WHITE]]
            
            mi2.setName("Knife");
            mi2.setAge(99);
            mi2.getCar().setColor(CarColor.BLUE);
            System.out.println(mi2);       // MyInstance [name=Knife, age=99, car=Car->[name=Ford, color=BLUE]]
            
            // Nothing is changed for copy_mi2.
            System.out.println(copy_mi2);  // MyInstance [name=Finix, age=80, car=Car->[name=Ford, color=WHITE]]
            System.out.println();
            
        } catch (CloneNotSupportedException ce) {
            System.out.println("CloneNotSupportedException: " + ce.getMessage());
        }
    }
    
    public static void main(String[] argv) {
        test_01();
        test_02();
    }
}
