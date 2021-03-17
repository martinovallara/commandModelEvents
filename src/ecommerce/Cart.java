package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private ArrayList<SummaryItem> summaryItems;
    private ArrayList<CartItem> cart;

    public Cart() {
        summaryItems = new ArrayList<>();
        cart = new ArrayList<>();
    }

    public List<SummaryItem> summary() {
        return summaryItems;
    }

    public void add(CartItem cartItem) {

       boolean isAlreadyPresentItem = cart.stream().anyMatch(item -> item.is(cartItem.getId()));
        if (!isAlreadyPresentItem) {
            cart.add(cartItem);
            summaryItems.add(new SummaryItem(cartItem.getId(), cartItem.getQuantity()));
        } else {
            SummaryItem summaryItem = summaryItems.stream().filter(item -> item.is(cartItem.getId())).findFirst().get();
            summaryItem.addQuantity(cartItem.getQuantity());
        }

    }
}


