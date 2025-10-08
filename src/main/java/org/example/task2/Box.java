package org.example.task2;

public class Box {
    private final double length;
    private final double height;
    private final double width;

    public Box(double length, double height, double width) {
        this.length = setValue(length);
        this.height = setValue(height);
        this.width = setValue(width);
    }

    // Перевірка коректності сторін (закритий сеттер)
    private double setValue(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Сторони мають бути більші за нуль!");
        }
        return value;
    }

    public double surfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    public double lateralSurfaceArea() {
        return 2 * (length * height + width * height);
    }

    public double volume() {
        return (length * width * height);
    }

    public static void main(String[] args) {
        Box box = new Box(5, 3, 4);

        System.out.println("Surface Area: " + box.surfaceArea());
        System.out.println("Lateral Surface Area: " + box.lateralSurfaceArea());
        System.out.println("Volume: " + box.volume());
    }
}


