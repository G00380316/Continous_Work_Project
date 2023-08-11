package ie.atu.shopping_cart;


import lombok.Getter;

@Getter
public class Item {

    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        setPrice(price);
        setName(name);
        setQuantity(quantity);

    }

    public void setName(String name){
        if(name.length()>2){
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("This is not a valid name. All Item contains names of 3 letters or above can be added");
        }
    }

    public void setPrice(double price){
        if(price > 0){
            this.price = price;
        }
        else {
            throw new IllegalArgumentException("This is not a valid price. All Item prices above 0 can be added ");
        }
    }

    public void setQuantity(int quantity){
        if(quantity >= 1){
            this.quantity = quantity;
        }
        else {
            throw new IllegalArgumentException("This is not a valid quantity. Only Items with a quantity of 1 or above can be added");
        }
    }
}
