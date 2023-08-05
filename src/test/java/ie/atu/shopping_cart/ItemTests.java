package ie.atu.shopping_cart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTests {

    private Item item;

    @BeforeEach
    void setUp() {
         item = new Item("Book", 10.99);
    }

    @Test
    public void testGetName(){

        assertEquals("Book", item.getName(), "Item name should match");
    }

    @Test
    public void testGetPrice() {

        assertEquals(2.49, item.getPrice(), 0.001, "Item price should match");
    }

    @AfterEach
    void tearDown() {
    }
}