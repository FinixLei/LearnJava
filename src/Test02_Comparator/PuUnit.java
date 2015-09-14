package Test02_Comparator;

import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;


public class PuUnit {
    private Integer pu_id;
    private String pu_name;
    private String pu_desc;
    private BigDecimal pu_price;
    private Timestamp pu_shelf_time;
    
    private List<ItemUnit> item_list;
    
    public Integer getPu_id() {
        return pu_id;
    }

    public void setPu_id(Integer pu_id) {
        this.pu_id = pu_id;
    }

    public String getPu_name() {
        return pu_name;
    }

    public void setPu_name(String pu_name) {
        this.pu_name = pu_name;
    }

    public String getPu_desc() {
        return pu_desc;
    }

    public void setPu_desc(String pu_desc) {
        this.pu_desc = pu_desc;
    }

    public BigDecimal getPu_price() {
        return pu_price;
    }

    public void setPu_price(BigDecimal pu_price) {
        this.pu_price = pu_price;
    }

    public List<ItemUnit> getItem_list() {
        return item_list;
    }

    public void setItem_list(List<ItemUnit> item_list) {
        this.item_list = item_list;
    }
    
    public Timestamp getPu_shelf_time() {
        return pu_shelf_time;
    }

    public void setPu_shelf_time(Timestamp pu_shelf_time) {
        this.pu_shelf_time = pu_shelf_time;
    }

    @Override
    public String toString() {
        return "PuUnit [pu_id=" + pu_id + ", pu_name=" + pu_name + ", pu_desc=" + pu_desc + ", pu_price=" + pu_price
                + ", pu_shelf_time=" + pu_shelf_time + ", item_list=" + item_list + "]";
    }
}
