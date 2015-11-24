package Test04_Comparable;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class StudentTest {
    public static void main(String[] argv) {
        test_case1();
    }
    
    private static void test_case1() {
        List<Student> sl = new ArrayList<Student>();
        sl.add(new Student(501L, "Judy", Gender.female, Grade.GradeFive, 90.0));
        sl.add(new Student(502L, "Sandy", Gender.male, Grade.GradeFive, 76));
        sl.add(new Student(503L, "John", Gender.male, Grade.GradeFive, 87));
        sl.add(new Student(504L, "Carl", Gender.male, Grade.GradeFive, 64));
        sl.add(new Student(505L, "Sindy", Gender.female, Grade.GradeFive, 45));
        sl.add(new Student(601L, "Merry", Gender.female, Grade.GradeSix, 60));
        sl.add(new Student(506L, "Dave", Gender.male, Grade.GradeFive, 89));
        
        Collections.sort(sl);
        
        for (Student s : sl) {
            System.out.println(s.getId() + " " + s.getName() + ":\t" 
                        + s.getGrade().name() + "\t" + s.getScore()); 
        }
        
        /*
         *  505 Sindy:   GradeFive   45.0
            504 Carl:   GradeFive   64.0
            502 Sandy:  GradeFive   76.0
            503 John:   GradeFive   87.0
            506 Dave:   GradeFive   89.0
            501 Judy:   GradeFive   90.0
            601 Merry:  GradeSix    60.0
         */
    }
}
