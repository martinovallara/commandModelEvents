import ecommerce.Cart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class eCommerceTest {

    @Test
    public void emptyCart() {
        Cart cart = new Cart();
        assertTrue(cart.summary().isEmpty());
    }



}
