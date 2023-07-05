package io.gitgub.yeop.ladderGame.destination;

public record Destination(String target) {
    private static final String MINIMUM_LENGTH_ERROR = "도착지 정보는 %s 글자를 초과할 수 없습니다.";
    private static final int MINIMUM_LENGTH = 5;

    public Destination {
        validate(target);
    }

    public void validate(String target) {
        if (target.length() > MINIMUM_LENGTH) {
            throw new IllegalArgumentException(MINIMUM_LENGTH_ERROR.formatted(MINIMUM_LENGTH));
        }
    }
}
