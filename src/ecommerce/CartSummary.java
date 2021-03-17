package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class CartSummary {
    private ArrayList<SummaryItem> summaryItems;

    public CartSummary() {
        summaryItems = new ArrayList<>();
    }

    public List<SummaryItem> summaryItems() {
        return summaryItems;
    }

    public void receives(EventType eventType) {

        CartItem itemToAdd = eventType.getItem();
        if (eventType.equals(AddNewItemEvent.class)) {
            addNew(itemToAdd);
            return;

        } else if (eventType.equals(IncreaseItemEvent.class)) {
            increaseQuantity(itemToAdd);
            return;
        }

        throw new IllegalStateException("Unexpected value: " + eventType.getClass().getName());
    }

    private void addNew(CartItem itemToAdd) {
        summaryItems.add(new SummaryItem(itemToAdd.getId(), itemToAdd.getQuantity()));
    }

    private void increaseQuantity(CartItem itemToAdd) {
        SummaryItem summaryItem = summaryItems.stream().filter(item -> item.is(itemToAdd.getId())).findFirst().get();
        summaryItem.addQuantity(itemToAdd.getQuantity());
    }
}
