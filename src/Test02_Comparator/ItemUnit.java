package Test02_Comparator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class ItemUnit {
    private BigInteger item_id;
    private BigDecimal item_price;
    private String pic_url;
    private Timestamp shelf_time;
    
    public BigInteger getItem_id() {
        return item_id;
    }
    public void setItem_id(BigInteger item_id) {
        this.item_id = item_id;
    }
    public BigDecimal getItem_price() {
        return item_price;
    }
    public void setItem_price(BigDecimal item_price) {
        this.item_price = item_price;
    }
    public String getPic_url() {
        return pic_url;
    }
    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
    public Timestamp getShelf_time() {
        return shelf_time;
    }
    public void setShelf_time(Timestamp shelf_time) {
        this.shelf_time = shelf_time;
    }
    @Override
    public String toString() {
        return "ItemUnit [item_id=" + item_id + ", item_price=" + item_price + ", pic_url=" + pic_url + ", shelf_time="
                + shelf_time + "]";
    }
    
    
}
