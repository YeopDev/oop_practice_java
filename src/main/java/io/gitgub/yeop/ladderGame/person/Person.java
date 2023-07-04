package io.gitgub.yeop.ladderGame.person;

public record Person(String name) {
    private static final int MINIMUM_SIZE = 5;

    public Person {
        validate(name);
    }

    private void validate(String name) {
        if (name.isEmpty() || name.length() > MINIMUM_SIZE) {
            throw new IllegalArgumentException("사람 이름은 최대 %d 글자 입니다. (현재 값 %d)".formatted(MINIMUM_SIZE, name.length()));
        }
    }
}