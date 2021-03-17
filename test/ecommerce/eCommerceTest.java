package ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class eCommerceTest {

    @Test
    public void empty_cart() {
        Cart cart = new Cart();
        assertTrue(cart.summary().isEmpty());
    }

    @Test
    void add_item() {
        Cart cart = new Cart();
        cart.add(new CartItem("itemId", 1));
        assertEquals(cart.summary().size(), 1);
    }

    @Test
    void add_another_item() {
        Cart cart = new Cart();
        cart.add(new CartItem("itemId1", 1));
        cart.add(new CartItem("itemId2", 1));
        assertEquals(cart.summary().size(), 2);
    }

    @Test
    void add_same_item() {
        Cart cart = new Cart();
        cart.add(new CartItem("itemId1", 1));
        cart.add(new CartItem("itemId1", 1));
        assertEquals(cart.summary().size(), 1);
    }

    @Test
    void add_too_many_item() {
        Cart cart = new Cart();
        assertThrows(IllegalArgumentException.class,
                () -> cart.add(new CartItem("itemId1", 100)));
    }

    @Test
    void add_too_many_at_same_item() {
        Cart cart = new Cart();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cart.add(new CartItem("itemId1", 1));
                    cart.add(new CartItem("itemId1", 99));
                });
    }
}

