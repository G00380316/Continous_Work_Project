package ie.atu.shopping_cart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTests {
//Testing functions more than implementation so more on actions then criteria
    private ShoppingCart shoppingcart;

   @BeforeEach
    void setUp() {
       shoppingcart = new ShoppingCart();
    }

    @Test
    public void testAddItem(){
        shoppingcart.addItem(new Item("Bible", 33.99,1));

        int totalItemCount = shoppingcart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(1);
    }

    @Test
    public void testAddItemWithQuantity(){
        shoppingcart.addItem(new Item("Bible", 33.99,2));

        int totalItemCount = shoppingcart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(1);
    }

    @Test
    public void testAddQuantityOfItem(){
        Item item1 = new Item("Item1", 20.0,1);

        shoppingcart.addItem(item1);
        shoppingcart.addItem(item1);

        int totalItemCount = shoppingcart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(1);
        assertThat(shoppingcart.quantity()).isEqualTo(2);
    }

    @Test
    public void testPriceOfItemWithQuantity(){
        shoppingcart.addItem(new Item("Bible", 33.99,2));

        double totalPrice = shoppingcart.calculateTotalPrice();
        assertEquals(67.98, totalPrice);;
    }


    @Test
    public void testRemoveItem(){
        Item item1 = new Item("Item1", 10.0,1);
        Item item2 = new Item("Item2", 20.0,1);

        shoppingcart.addItem(item1);
        shoppingcart.addItem(item2);

        shoppingcart.removeItem(item1);

        assertFalse(shoppingcart.containsItem(item1));
        assertTrue(shoppingcart.containsItem(item2));
    }

    @Test
    public void testAddMultipleItems(){
        Item item1 = new Item("Item1", 10.0,1);
        Item item2 = new Item("Item2", 20.0,1);
        Item item3 = new Item("Item3", 15.0,1);

        shoppingcart.addItem(item1);
        shoppingcart.addItem(item2);
        shoppingcart.addItem(item3);

        assertTrue(shoppingcart.containsItem(item1));
        assertTrue(shoppingcart.containsItem(item2));
        assertTrue(shoppingcart.containsItem(item3));

        int totalItemCount = shoppingcart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(3);
    }

    @Test
    public void testCalculateTotalPrice(){
        Item item1 = new Item("Item1", 10.0,1);
        Item item2 = new Item("Item2", 20.0,1);


        shoppingcart.addItem(item1);
        shoppingcart.addItem(item2);


        double totalPrice = shoppingcart.calculateTotalPrice();

        assertEquals(30.0, totalPrice);
    }

    @Test
    public void testNoItems(){
        Item item1 = new Item("Item1", 10.0,1);
        Item item2 = new Item("Item2", 20.0,1);
        Item item3 = new Item("Item3", 15.0,1);

        shoppingcart.addItem(item1);
        shoppingcart.addItem(item2);
        shoppingcart.addItem(item3);

        shoppingcart.clearCart();

        int totalItemCount = shoppingcart.totalNumberOfItems();
        assertThat(totalItemCount).isEqualTo(0);
    }

    @AfterEach
    void tearDown() {
    }


}