package ecommerce;

public abstract class EventType {

    protected CartItem itemToAdd;

    public EventType(CartItem itemToAdd) {

        this.itemToAdd = itemToAdd;
    }

    public CartItem getItem() {
        return this.itemToAdd;
    }
}

