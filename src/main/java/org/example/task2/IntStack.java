package org.example.task2;

public class IntStack {
    private int[] elements;
    private int size;
    private static final int CAPACITY = 25;

    public IntStack(){
        elements = new int[CAPACITY];
        size = 0;
    }

    // Додавання елементу
    public void push(int value){
        if (size == elements.length) {
            grow();
        }
        elements[size++] = value;
    }

    // Видалення елементу
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек порожній!");
        }
        return elements[--size];
    }

    // Перегляд першого елементу
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек порожній!");
        }
        return elements[size - 1];
    }

    // Чи пустий стек
    public boolean isEmpty() {
        return size == 0;
    }

    // Розмір стека
    public int size() {
        return size;
    }

    // Очищення стека
    public void clear() {
        size = 0;
    }

    // Збільшення розміру масиву (моделювання динамічного шляхом копіювання в новий)
    private void grow() {
        int newCapacity = elements.length * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }
}
