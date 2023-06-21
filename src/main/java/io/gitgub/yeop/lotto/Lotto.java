package io.gitgub.yeop.lotto;

import java.util.List;

public record Lotto(List<Integer> numbers) {
    @Override
    public String toString() {
        return "번호: " + numbers;
    }
}
