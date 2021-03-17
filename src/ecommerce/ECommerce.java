package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class ECommerce {


    private ArrayList<SummaryItem> summaryItems;
    private Cart cart;

    public ECommerce() {
        summaryItems = new ArrayList<>();
        cart = new Cart();
    }

    public List<SummaryItem> summary() {
        return summaryItems;
    }

    public void add(CartItem itemToAdd) {

        cart.canAdd(itemToAdd);
        EventType eventType= cart.add(itemToAdd);


        if (eventType == EventType.ADD_NEW_ITEM) {
            summaryItems.add(new SummaryItem(itemToAdd.getId(), itemToAdd.getQuantity()));
        } else {
            SummaryItem summaryItem = summaryItems.stream().filter(item -> item.is(itemToAdd.getId())).findFirst().get();
            summaryItem.addQuantity(itemToAdd.getQuantity());
        }
    }
}


