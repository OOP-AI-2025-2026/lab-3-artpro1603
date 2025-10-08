package org.example.task2;

import java.util.Arrays;
import java.util.Objects;

public class Cart {

    private Item[] contents;
    private int index;

    public Cart(int capacity) {
        this.contents = new Item[capacity];
        this.index = 0;
    }

    public void removeById(long itemId) {

        int foundItemIndex = findItemInArray(itemId);

        if (foundItemIndex == -1)
            return;

        shiftArray(foundItemIndex);
    }

    public void shiftArray(int itemIndex) {
        for (int i = itemIndex; i < this.index - 1; i++) {
            this.contents[i] = this.contents[i + 1];
        }
        this.contents[this.index-1] = null;
        this.index--;
    }

    public int findItemInArray(long itemId) {
        for (int i = 0; i < this.index; i++) {
            if (this.contents[i].getId() == itemId) {
                return i;
            }
        }

        return -1;
    }

    void add(Item item) {
        if (isCartFull())
            return;

        this.contents[this.index] = item;
        this.index++;
    }

    public boolean isCartFull() {
        return index == contents.length;
    }

    public Item[] getContents() {
        return Arrays.copyOf(this.contents, this.index);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "contents=" + Arrays.toString(
                Arrays.stream(contents)
                        .filter(Objects::nonNull).toArray(Item[]::new)  // фільтрація усіх
        ) +                                                             // null(видалених) елементів
                '}' + "\n";
    }
}
