package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private ArrayList<SummaryItem> summaryItems;

    public Cart() {
        summaryItems = new ArrayList<>();
    }

    public List<SummaryItem> summary() {
        return summaryItems;
    }

    public void add(CartItem CartItem) {
        summaryItems.add(new SummaryItem());
    }
}


