package io.gitgub.yeop.ladderGame.util;

import java.util.random.RandomGenerator;

@FunctionalInterface
public interface RandomUtil {
    int create();

    RandomUtil AUTO = () -> RandomGenerator.getDefault().nextInt(2);
}
