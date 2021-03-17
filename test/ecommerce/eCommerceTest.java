package ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class eCommerceTest {

    @Test
    public void emptyCart() {
        Cart cart = new Cart();
        assertTrue(cart.summary().isEmpty());
    }

    @Test
    void addItem() {
        Cart cart = new Cart();
        cart.add(new CartItem("itemId", 1));
        assertEquals(cart.summary().size(), 1);
    }

    @Test
    void addAnotherItem() {
        Cart cart = new Cart();
        cart.add(new CartItem("itemId1", 1));
        cart.add(new CartItem("itemId2", 1));
        assertEquals(cart.summary().size(), 2);
    }

    @Test
    void addSameItem() {
        Cart cart = new Cart();
        cart.add(new CartItem("itemId1", 1));
        cart.add(new CartItem("itemId1", 1));
        assertEquals(cart.summary().size(), 1);
    }
}
