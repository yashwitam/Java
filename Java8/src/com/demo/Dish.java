package com.demo;

public class Dish {

    private String dishName;
    private int calories;
    private boolean isVegetarian;
    private DishType dishType;

    @Override
    public String toString() {
        return "Dish{" +
                "dishName='" + dishName + '\'' +
                ", calories=" + calories +
                ", isVegetarian=" + isVegetarian +
                ", dishType=" + dishType +
                '}';
    }

    public Dish(String dishName, boolean isVegetarian, int calories, DishType dishType) {
        this.dishName = dishName;
        this.isVegetarian = isVegetarian;
        this.calories = calories;
        this.dishType = dishType;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }
}
