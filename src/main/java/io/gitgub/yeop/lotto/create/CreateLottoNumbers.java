package io.gitgub.yeop.lotto.create;

import java.util.List;
import java.util.random.RandomGenerator;

@FunctionalInterface
public interface CreateLottoNumbers {
    List<Integer> create(int SIZE);

    CreateLottoNumbers AUTO = (int SIZE) -> RandomGenerator.getDefault()
            .ints(1, 45)
            .distinct()
            .limit(SIZE)
            .sorted()
            .boxed()
            .toList();
}
