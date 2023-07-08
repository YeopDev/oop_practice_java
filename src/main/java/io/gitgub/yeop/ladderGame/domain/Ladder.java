package io.gitgub.yeop.ladderGame.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public class Ladder {
    private static final String MINIMUM_SIZE_ERROR = "사다리 길이는 %d 보다 작을 수 없습니다.";
    private static final int MINIMUM_SIZE = 1;
    private static final int POINT_START_INDEX = 0;

    private List<Line> lineList;

    public Ladder(int height, int width) {
        validate(height);
        this.lineList = create(height, width);
    }

    public List<Line> readOnlyLines() {
        return unmodifiableList(lineList);
    }

    private List<Line> create(int height, int width) {
        return IntStream.range(POINT_START_INDEX, height)
                .mapToObj(index -> new Line(width))
                .toList();
    }

    private void validate(int height) {
        if (height < MINIMUM_SIZE) {
            throw new IllegalArgumentException(MINIMUM_SIZE_ERROR.formatted(MINIMUM_SIZE));
        }
    }
}
