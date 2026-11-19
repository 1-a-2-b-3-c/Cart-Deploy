package murach.business;

import java.util.*;

public class Cart {
    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        for (Item existingItem : items) {
            if (existingItem.getId().equals(item.getId())) {
                existingItem.setQuantity(existingItem.getQuantity() + 1);
                return;
            }
        }
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public Item findItemOfId(String Id) {
        for(Item item:this.items) {
            if(item.getId().equals(Id)) {
                return item;
            }
        }
        return null;
    }

    public void removeItemOfId(String Id) {
        for(int i=0; i<this.items.size(); i++) {
            if(this.items.get(i).getId().equals(Id)) {
                this.items.remove(i);
                break;
            }
        }
    }
}


