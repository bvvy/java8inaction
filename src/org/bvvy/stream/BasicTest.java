package org.bvvy.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class BasicTest {
    private List<Dish> dishes = null;
    private Map<String, Dish> dishMap = new HashMap<>();


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

    @Test
    public void testFilter() {
        List<Dish> result = Util.filter(dishes, dish -> dish.getCalories() >= 100);
        result.stream().map(Dish::getCalories).forEach(System.out::println);
        result.forEach(System.out::println);
    }

    @Test
    public void testMap() {
        List<String> highCaloricDishesName = dishes.stream()
                .filter(dish -> dish.getCalories() >= 100)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        highCaloricDishesName.forEach(System.out::println);
    }

    @Test
    public void testForeach() {
        dishMap.forEach((s, dish) -> {
            System.out.println(s + "--------->" + dish);
        });

    }

    @Test
    public void testDistinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
    }

    @Test
    public void testSkip() {
        List<Dish> dishList = dishes.stream()
                .filter(d->d.getCalories()>100)
                .skip(2)
                .collect(toList());
        dishList.forEach(System.out::println);
    }


}
