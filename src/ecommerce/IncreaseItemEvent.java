package ecommerce;

public class IncreaseItemEvent extends EventType {

    public IncreaseItemEvent(CartItem itemToAdd) {
        super(itemToAdd);
    }
}
