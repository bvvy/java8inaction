package org.bvvy.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {

    @Test
    public void testMap() {
        List<String> words = Arrays.asList("java 8", "lambdas", "in", "action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        wordLengths.forEach(System.out::println);
    }
}
