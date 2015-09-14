package Test02_Comparator;

import java.util.Comparator;

public class PuUnitPriceAscComparator implements Comparator<PuUnit> {
    public int compare(PuUnit p1, PuUnit p2) {
        return p1.getPu_price().compareTo(p2.getPu_price());
    }
}
