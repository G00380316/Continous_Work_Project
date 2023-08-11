package ie.atu.shopping_cart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTests {

    private Item item;

    @BeforeEach
    void setUp() {
         item = new Item("Book", 10.99,1);
    }

    @Test
    public void testGetName(){

        assertEquals("Book", item.getName(), "Item name should match");
    }

    @Test
    public void testGetPrice(){

        assertEquals(10.99, item.getPrice(), 0.001, "Item price should match");
    }

    @Test
    public void testGetQuantity(){

        assertEquals(1, item.getQuantity(), "Item quantity should match");
    }

    @Test
    void testNameFail(){
        Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {new Item("Bo", 15.99, 1);});
        assertEquals("This is not a valid name. All Item contains names of 3 letters or above can be added", exMessage.getMessage());
    }

    @Test
    void testPriceFail(){
        Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {new Item("Book", 0, 1);});
        assertEquals("This is not a valid price. All Item prices above 0 can be added ", exMessage.getMessage());
    }

    @Test
    void testQuantityFail(){
        Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {new Item("Book", 15.99, 0);});
        assertEquals("This is not a valid quantity. Only Items with a quantity of 1 or above can be added", exMessage.getMessage());
    }


    @AfterEach
    void tearDown() {
    }
}