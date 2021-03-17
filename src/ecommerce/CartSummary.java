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
        if (eventType.getClass().equals(AddNewItemEvent.class)) {
            summaryItems.add(new SummaryItem(itemToAdd.getId(), itemToAdd.getQuantity()));
            return;
        } else if (eventType.getClass().equals(IncreaseItemEvent.class)) {
            SummaryItem summaryItem = summaryItems.stream().filter(item -> item.is(itemToAdd.getId())).findFirst().get();
            summaryItem.addQuantity(itemToAdd.getQuantity());
            return;
        }

        throw new IllegalStateException("Unexpected value: " + eventType.getClass().getName());
    }
}
