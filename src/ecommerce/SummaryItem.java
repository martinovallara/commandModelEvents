package ecommerce;

public class SummaryItem {
    final String id;
    private int quantity;

    public SummaryItem(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Boolean is(String id) {
        return this.id.equals(id);
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
