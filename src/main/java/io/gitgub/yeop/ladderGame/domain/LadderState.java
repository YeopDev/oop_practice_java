package io.gitgub.yeop.ladderGame.domain;

import java.util.Arrays;

public enum LadderState {
    EMPTY(true, "     "),
    HORIZONTAL(false, "-----");

    private boolean isPoint;
    private String line;

    LadderState(boolean isPoint, String line) {
        this.isPoint = isPoint;
        this.line = line;
    }

    public static String ofLine(Boolean isPoint) {
        return Arrays.stream(values())
                .filter(line -> line.isPoint == isPoint)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException())
                .line;
    }
}
