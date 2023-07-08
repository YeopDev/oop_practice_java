package io.gitgub.yeop.ladderGame.domain;

import io.gitgub.yeop.ladderGame.strategy.Point;
import io.gitgub.yeop.ladderGame.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Line {
    private static final String MINIMUM_PERSON_ERROR = "2명 이상 참여해야합니다. (현재 값 %d)";
    private static final int MINIMUM_PERSON = 2;
    private static final int MINUS_INDEX_SIZE = 1;

    private final PointStrategy point;
    private final List<Boolean> pointList;

    public Line(int width) {
        this(width, Point.location());
    }

    public Line(int width, PointStrategy point) {
        validate(width);
        this.point = point;
        this.pointList = createBar((width - MINUS_INDEX_SIZE), new ArrayList<>());
    }

    public List<Boolean> readOnlyPoints() {
        return unmodifiableList(pointList);
    }

    private List<Boolean> createBar(int width, List<Boolean> points) {
        if (points.isEmpty()) {
            createBar(width, addPoint(points, point.isPoint()));
        }
        if (width == points.size()) {
            return addPoint(points, Boolean.FALSE);
        }
        if (!isMaxSize(width, points) && !points.get(points.size() - MINUS_INDEX_SIZE)) {
            createBar(width, addPoint(points, point.isPoint()));
        }
        if (!isMaxSize(width, points) && points.get(points.size() - MINUS_INDEX_SIZE)) {
            createBar(width, addPoint(points, Boolean.FALSE));
        }
        return points;
    }

    private boolean isMaxSize(int downGradeMaxSize, List<Boolean> points) {
        return downGradeMaxSize <= points.size();
    }

    private List<Boolean> addPoint(List<Boolean> points, boolean isPoint) {
        points.add(isPoint);
        return points;
    }

    private void validate(int width) {
        if (width < MINIMUM_PERSON) {
            throw new IllegalArgumentException(MINIMUM_PERSON_ERROR.formatted(width));
        }
    }
}
