package ecommerce;

import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;
import java.util.Optional;

public class Cart {
    private ArrayList<CartItem> cartItems;

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

            itemInCart.validate(itemToAdd);
            
            itemInCart.addQuantity(itemToAdd);
            return new IncreaseItemEvent(itemToAdd);
        }
        
        itemToAdd.validate();
        
        cartItems.add(itemToAdd);
        return new AddNewItemEvent(itemToAdd);
    }
}
