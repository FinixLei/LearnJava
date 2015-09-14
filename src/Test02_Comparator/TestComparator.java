package Test02_Comparator;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TestComparator {
    public static void print_puunit_list(List<PuUnit> pu_list) {
        for (int i=0; i<pu_list.size(); i++) {
            System.out.println(pu_list.get(i));
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Test My Comparator!");
        
        PuUnit p1 = new PuUnit();
        p1.setPu_id(100);
        p1.setPu_price(BigDecimal.valueOf(9999));
        p1.setPu_shelf_time(Timestamp.valueOf("2015-09-14 23:11:10"));
        
        PuUnit p2 = new PuUnit();
        p2.setPu_id(200);
        p2.setPu_price(BigDecimal.valueOf(39999));
        p2.setPu_shelf_time(Timestamp.valueOf("2015-09-10 23:11:10"));
        
        PuUnit p3 = new PuUnit();
        p3.setPu_id(300);
        p3.setPu_price(BigDecimal.valueOf(59999));
        p3.setPu_shelf_time(Timestamp.valueOf("2015-09-12 23:11:10"));
        
        List<PuUnit> pu_list = new ArrayList<PuUnit>();
        pu_list.add(p1);
        pu_list.add(p2);
        pu_list.add(p3);
        
        System.out.println("Price ASC");
        Collections.sort(pu_list, new PuUnitPriceAscComparator());
        print_puunit_list(pu_list);
        System.out.println("");
        
        System.out.println("Price DESC");
        Collections.sort(pu_list, new PuUnitPriceDescComparator());
        print_puunit_list(pu_list);
        System.out.println("");
        
        System.out.println("Shelf_Time ASC");
        Collections.sort(pu_list, new PuUnitShelftimeAscComparator());
        print_puunit_list(pu_list);
        System.out.println("");
        
        System.out.println("Shelf_Time DESC");
        Collections.sort(pu_list, new PuUnitShelftimeDescComparator());
        print_puunit_list(pu_list);
        System.out.println("");
    }
}
