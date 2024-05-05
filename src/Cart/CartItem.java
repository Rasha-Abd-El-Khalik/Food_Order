package Cart;
import java.util.ArrayList;
import login.*;
import Menu.*;
public class CartItem {
    public Dish foodItem;
    public String extra;
    public double extra_price;
    private int quantity ;
    public CartItem(Dish foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }
    public void addextratocart(String extra,double extra_price)
    {
        this.extra=extra;
        this.extra_price=extra_price;
    }
    public Dish getFoodItem() {
        return foodItem;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}