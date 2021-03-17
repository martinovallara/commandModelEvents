package ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class eCommerceTest {

    @Test
    public void empty_cart() {
        ECommerce ECommerce = new ECommerce();
        assertTrue(ECommerce.summary().isEmpty());
    }

    @Test
    void add_item() {
        ECommerce ECommerce = new ECommerce();
        ECommerce.add(new CartItem("itemId", 1));
        assertEquals(ECommerce.summary().size(), 1);
    }

    @Test
    void add_another_item() {
        ECommerce ECommerce = new ECommerce();
        ECommerce.add(new CartItem("itemId1", 1));
        ECommerce.add(new CartItem("itemId2", 1));

        assertEquals(ECommerce.summary().size(), 2);

    }

    @Test
    void add_same_item() {
        ECommerce ECommerce = new ECommerce();
        ECommerce.add(new CartItem("itemId1", 1));
        ECommerce.add(new CartItem("itemId1", 1));
        assertEquals(ECommerce.summary().size(), 1);
        assertEquals(ECommerce.summary().get(0).getQuantity(), 2);
    }

    @Test
    void add_too_many_item() {
        ECommerce ECommerce = new ECommerce();
        assertThrows(IllegalArgumentException.class,
                () -> ECommerce.add(new CartItem("itemId1", 100)));
    }

    @Test
    void add_too_many_at_same_item() {
        ECommerce ECommerce = new ECommerce();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    ECommerce.add(new CartItem("itemId1", 1));
                    ECommerce.add(new CartItem("itemId1", 99));
                });
    }
}

