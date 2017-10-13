package org.bvvy.stream;

import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitInfoTest {

    public List<Dish> dishes = null;
    public Map<String, Dish> dishMap = new HashMap<>();


    @Before
    public void init() {
        dishes = new ArrayList<>();
        dishes.add(new Dish().withCalories(100).withName("apple"));
        dishes.add(new Dish().withCalories(85).withName("pear"));
        dishes.add(new Dish().withCalories(170).withName("candy"));
        dishes.add(new Dish().withCalories(101).withName("orange"));
        dishes.add(new Dish().withCalories(200).withName("watermelon"));
        dishes.forEach(dish -> dishMap.put(dish.getName(), dish));
    }
}
