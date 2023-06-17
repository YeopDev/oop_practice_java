package io.gitgub.yeop.numberBaseball;

public record Numbers(String target) {
    private static final int MINIMUM_LENGTH = 3;

    public Numbers {
        validate(target);
    }

    // 여기서 compareTo

    private void validate(String target) {
        if (target.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException("입력 길이는 %d 보다 작아야 합니다. (현재 값 %d)".formatted(MINIMUM_LENGTH, target.length()));
        }
        if(target.isBlank()){
            throw new IllegalArgumentException("입력된 값이 공백이 포함되어있습니다.");
        }
    }
}
