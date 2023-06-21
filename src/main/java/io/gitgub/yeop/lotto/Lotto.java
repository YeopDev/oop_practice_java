package io.gitgub.yeop.lotto;

import java.util.List;

public record Lotto(List<Integer> numbers) {
    public Lotto{
        validate(numbers);
    }

    @Override
    public String toString() {
        return "번호: " + numbers;
    }

    private void validate(List<Integer> numbers){
        if(numbers == null || numbers.isEmpty()){
            throw new IllegalArgumentException("번호가 생성된 시점에는 비어있을 수 없습니다.");
        }
    }
}
