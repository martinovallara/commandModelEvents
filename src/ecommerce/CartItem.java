package ecommerce;

public class CartItem {
    private String itemId;
    private int quantity;
    private static final int MAX_QUANTITY = 100;
    public CartItem(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public String getId() {
        return this.itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Boolean is(String itemId) {
        return this.itemId.equals(itemId);
    }

    public void addQuantity(CartItem itemToAdd) {
        this.quantity += itemToAdd.quantity;
    }

    public void validate(CartItem itemToAdd) {
        if (exceededMaxQuantity(this.getQuantity() + itemToAdd.getQuantity()))
            throw new IllegalArgumentException();
    }

    public void validate() {
        if (exceededMaxQuantity(this.getQuantity()))
            throw new IllegalArgumentException();
    }

    private boolean exceededMaxQuantity(int i) {
        return i >= MAX_QUANTITY;
    }
}
