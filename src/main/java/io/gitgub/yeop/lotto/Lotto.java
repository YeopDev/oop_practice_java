package io.gitgub.yeop.lotto;

import java.util.List;

public record Lotto(List<Integer> numbers) {
    private static final int MINIMUM_SIZE_NUMBERS = 6;

    public Lotto {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new NullPointerException("랜덤값은 비어있을 수 없습니다.");
        }
        if (numbers.size() != MINIMUM_SIZE_NUMBERS) {
            throw new IndexOutOfBoundsException("랜덤 사이즈는 %d와 같아야 합니다. (현재 값 %d)".formatted(MINIMUM_SIZE_NUMBERS, numbers.size()));
        }
    }
}
