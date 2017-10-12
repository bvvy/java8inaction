package org.bvvy.stream;

public class Dish {

    private String name;
    private int calories;

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dish withCalories(int calories) {
        this.calories = calories;
        return this;
    }

    public Dish withName(String name) {
        this.name = name;
        return this;
    }
    @Override
    public String toString() {
        return "Dish{" +
                "calories=" + calories +
                '}';
    }
}
