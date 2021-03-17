package ecommerce;

public class CartItem {
    private String itemId;
    private int quantity;

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
}
