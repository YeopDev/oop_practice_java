package io.gitgub.yeop.numberBaseball.user.createRandom;

import io.gitgub.yeop.numberBaseball.Numbers;

import java.util.random.RandomGenerator;

import static java.util.stream.Collectors.joining;

@FunctionalInterface
public interface RandomNumber {
    Numbers generator(int size);

    RandomNumber AUTO = (int SIZE) -> new Numbers(RandomGenerator.getDefault()
            .ints(1, 10)
            .distinct()
            .limit(3)
            .mapToObj(String::valueOf)
            .collect(joining()));
}
