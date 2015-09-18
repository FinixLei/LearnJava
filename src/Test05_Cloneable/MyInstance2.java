/*
 * Implement the deep copy via implementing the Cloneable interface. 
 */

package Test05_Cloneable;

public class MyInstance2 implements Cloneable {
    private String name;
    private int age;
    private Car car; 
    
    public MyInstance2(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    // Deep Copy
    public MyInstance2 clone() throws CloneNotSupportedException {
        MyInstance2 copy = (MyInstance2)super.clone();
        
        if (copy.getCar() != null) {
            copy.setCar(new Car(copy.getCar().getName(), copy.getCar().getColor()));
        }
        return copy;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "MyInstance [name=" + name + ", age=" + age + ", car=" + car + "]";
    }

   
}
