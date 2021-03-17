package ecommerce;

public abstract class EventType {

    protected CartItem itemToAdd;

    public EventType(CartItem itemToAdd) {

        this.itemToAdd = itemToAdd;
    }

    public CartItem getItem() {
        return this.itemToAdd;
    }

    @Override
    public boolean equals(Object eventTypeClass) {
        return this.getClass().equals(eventTypeClass);
    }
}

