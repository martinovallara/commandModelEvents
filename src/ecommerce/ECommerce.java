package ecommerce;

import java.util.List;

public class ECommerce {

    private Cart cart;
    public CartSummary summaryItems;

    public ECommerce() {

        cart = new Cart();
        summaryItems = new CartSummary();
    }

    public List<SummaryItem> summary() {
        return summaryItems.summaryItems();
    }

    public void add(CartItem itemToAdd) {

        EventType eventType = cart.add(itemToAdd);

        summaryItems.receives(eventType);


    }
}


