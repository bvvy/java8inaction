package org.bvvy.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class MapTest extends InitInfoTest{

    @Test
    public void testMap() {
        List<Integer> wordLengths = dishes.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        wordLengths.forEach(System.out::println);
    }

    @Test
    public void testFlatmap() {
        List<String> words = dishes.stream()
                .map(Dish::getName)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        words.forEach(System.out::println);
    }

    @Test
    public void testNumber() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        pairs.forEach(ints -> System.out.println(ints[1]+"--->"+ints[0]));

    }

    @Test
    public void testMatch() {
        boolean isHealthy = dishes.stream().anyMatch(d -> d.getCalories() < 50);
        System.out.println(isHealthy);
    }

    @Test
    public void testFind() {
        Optional<Dish> dish = dishes.stream().filter(d -> d.getCalories() > 100).findFirst();
        dish.ifPresent(System.out::println);
    }
}
