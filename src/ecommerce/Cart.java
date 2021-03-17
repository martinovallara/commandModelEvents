package ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {

    public static final int MAX_QUANTITY = 100;
    private ArrayList<SummaryItem> summaryItems;
    private ArrayList<CartItem> cart;

    public Cart() {
        summaryItems = new ArrayList<>();
        cart = new ArrayList<>();
    }

    public List<SummaryItem> summary() {
        return summaryItems;
    }

    public void add(CartItem itemToAdd) {

        Optional<CartItem> cartItem = cart.stream().filter(item -> item.is(itemToAdd.getId())).findFirst();
        if (!cartItem.isPresent()) {
            if (itemToAdd.getQuantity() >= MAX_QUANTITY) throw new IllegalArgumentException();
            cart.add(itemToAdd);
            summaryItems.add(new SummaryItem(itemToAdd.getId(), itemToAdd.getQuantity()));
        } else {
            CartItem itemInCart = cartItem.get();
            if (itemInCart.getQuantity() + itemToAdd.getQuantity() >= MAX_QUANTITY)
                throw new IllegalArgumentException();
            SummaryItem summaryItem = summaryItems.stream().filter(item -> item.is(itemInCart.getId())).findFirst().get();
            summaryItem.addQuantity(itemInCart.getQuantity());
        }

    }
}


