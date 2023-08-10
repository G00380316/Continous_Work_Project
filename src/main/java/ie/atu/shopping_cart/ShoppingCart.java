package ie.atu.shopping_cart;

import java.util.ArrayList;
import java.util.List;
public class ShoppingCart {

    private List<Item> items;
    private int quantity;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        if (!items.contains(item)){
            items.add(item);
            quantity = item.getQuantity();
        }
        else {
            quantity++;
        }
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public boolean containsItem(Item item){
        return items.contains(item);
    }

    public double calculateTotalPrice(){
        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    public void clearCart(){
        items.clear();
    }

    public int totalNumberOfItems(){
        return items.size();
    }

    public int quantity(){return quantity;}
}


