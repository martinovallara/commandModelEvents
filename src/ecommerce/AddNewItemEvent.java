package ecommerce;

public class AddNewItemEvent extends EventType {

    public AddNewItemEvent(CartItem itemToAdd) {
        super(itemToAdd);
    }
}
