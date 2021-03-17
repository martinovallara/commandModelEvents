package ecommerce;

import java.util.List;

public class ECommerce {

    private Cart cart;
    public CartSummary cartSummary;

    public ECommerce() {
        cart = new Cart();
        cartSummary = new CartSummary();
    }

    public List<SummaryItem> summary() {
        return cartSummary.summaryItems();
    }

    public void add(CartItem itemToAdd) {
        EventType eventType = cart.add(itemToAdd);
        cartSummary.receives(eventType);
    }
}


