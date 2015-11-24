/*
 * Use Object.clone() to do Shadow copy
 */

package Test05_Cloneable;

enum CarColor{WHITE, BLACK, RED, BLUE, YELLOW, GREEN, MIXED};

class Car {
    private String name;
    private CarColor color;
    
    public Car(String name, CarColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car->[name=" + name + ", color=" + color + "]";
    }
    
    
}

public class MyInstance implements Cloneable {
    private String name;
    private int age;
    private Car car; 
    
    public MyInstance(String name, int age, Car car) {
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
    
    public MyInstance clone() throws CloneNotSupportedException {
        return (MyInstance)super.clone();
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
