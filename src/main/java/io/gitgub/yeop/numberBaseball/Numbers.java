package io.gitgub.yeop.numberBaseball;

import java.util.HashSet;
import java.util.Set;

public record Numbers(String target) {
    private static final int MINIMUM_LENGTH = 3;

    public Numbers {
        validate(target);
    }

    public int strike(Numbers otherNumber) {
        char[] self = target.toCharArray();
        char[] that = otherNumber.target.toCharArray();
        int strikeCount = 0;

        for (int i = 0; i < self.length; i++) {
            if (self[i] == that[i]) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int ball(Numbers otherNumber) {
        char[] self = target.toCharArray();
        char[] that = otherNumber.target.toCharArray();
        int ballCount = 0;

        Set<Character> selfNumbers = new HashSet<>();
        for (char digit : self) {
            selfNumbers.add(digit);
        }
        for (char digit : that) {
            if (selfNumbers.contains(digit)) {
                ballCount++;
                selfNumbers.remove(digit);
            }
        }
        return ballCount;
    }

    private void validate(String target) {
        if (target.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException("입력 길이는 %d 보다 작아야 합니다. (현재 값 %d)".formatted(MINIMUM_LENGTH, target.length()));
        }
        if (target.isBlank()) {
            throw new IllegalArgumentException("입력된 값이 공백이 포함되어있습니다.");
        }
    }
}
