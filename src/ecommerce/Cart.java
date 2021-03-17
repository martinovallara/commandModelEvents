package ecommerce;

import java.util.ArrayList;
import java.util.Optional;

public class Cart {
    private ArrayList<CartItem> cartItems;
    public static final int MAX_QUANTITY = 100;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public Optional<CartItem> getItem(CartItem itemToAdd) {
        return cartItems.stream().filter(item -> item.is(itemToAdd.getId())).findFirst();
    }

    public EventType add(CartItem itemToAdd) {
        Optional<CartItem> cartItem = this.getItem(itemToAdd);
        if (cartItem.isPresent()) {
            CartItem itemInCart = cartItem.get();
            itemInCart.setQuantity(itemInCart.getQuantity() + itemToAdd.getQuantity());
            return EventType.INCREASE_QUANTITY;
        }
        cartItems.add(itemToAdd);
        return EventType.ADD_NEW_ITEM;
    }

    public void canAdd(CartItem itemToAdd) {
        Optional<CartItem> cartItem = this.getItem(itemToAdd);
        if (cartItem.isPresent()) {
            CartItem itemInCart = cartItem.get();
            if (itemInCart.getQuantity() + itemToAdd.getQuantity() >= MAX_QUANTITY)
                throw new IllegalArgumentException();
        }
        if (itemToAdd.getQuantity() >= MAX_QUANTITY) throw new IllegalArgumentException();

    }
}
