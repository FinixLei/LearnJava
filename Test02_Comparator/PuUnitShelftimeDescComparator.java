package Test02_Comparator;

import java.util.Comparator;

public class PuUnitShelftimeDescComparator implements Comparator<PuUnit> {
    public int compare(PuUnit p1, PuUnit p2) {
        return p2.getPu_shelf_time().compareTo(p1.getPu_shelf_time());
    }
}
