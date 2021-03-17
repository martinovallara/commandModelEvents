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

        EventType eventType= cart.add(itemToAdd);

        switch (eventType) {
            case ADD_NEW_ITEM:
                summaryItems.add(new SummaryItem(itemToAdd.getId(), itemToAdd.getQuantity()));
                break;
            case INCREASE_QUANTITY:
                SummaryItem summaryItem = summaryItems.stream().filter(item -> item.is(itemToAdd.getId())).findFirst().get();
                summaryItem.addQuantity(itemToAdd.getQuantity());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + eventType);
        }

    }
}


