package com.demo;

public class Apple {

    private int fruitId;
    private boolean isGreen;
    private String color;
    private int weight;

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public Apple(int fruitId, String color, int weight) {

        this.fruitId = fruitId;
        this.color = color;
        this.weight = weight;
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean getIsGreen() {
        return isGreen;
    }

    public void setIsGreen(boolean isGreen) {
        this.isGreen = isGreen;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
