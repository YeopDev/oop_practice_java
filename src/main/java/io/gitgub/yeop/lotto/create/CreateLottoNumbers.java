package io.gitgub.yeop.lotto.create;

import java.util.random.RandomGenerator;

import static java.util.stream.Collectors.joining;

@FunctionalInterface
public interface CreateLottoNumbers {
    String create(int SIZE);

    CreateLottoNumbers AUTO = (int SIZE) -> RandomGenerator.getDefault()
            .ints(1, 45)
            .distinct()
            .limit(SIZE)
            .sorted()
            .mapToObj(String::valueOf)
            .collect(
                    joining(", ", "[", "]")
            );
}
