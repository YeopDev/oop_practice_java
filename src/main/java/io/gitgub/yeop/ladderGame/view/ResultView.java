package io.gitgub.yeop.ladderGame.view;

import io.gitgub.yeop.ladderGame.domain.Ladder;
import io.gitgub.yeop.ladderGame.domain.LadderState;
import io.gitgub.yeop.ladderGame.domain.Line;
import io.gitgub.yeop.ladderGame.person.Person;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final String RUN_RESULT = "실행 결과";
    private static final String EMPTY = "";
    private static final String LINE = "|";

    public ResultView() {
        System.out.println(RUN_RESULT);
    }

    public void printPerson(List<Person> person) {
        person.stream()
                .forEach(this::printName);
        System.out.println(EMPTY);
    }

    private void printName(Person name) {
        System.out.print(String.format("%s", name));
    }

    public void printLadder(Ladder ladder) {
        ladder.readOnlyLines().stream()
                .forEach(this::printLine);
    }

    private void printLine(Line line) {
        System.out.print(String.format("%s", EMPTY));
        List<Boolean> points = line.readOnlyPoints();
        IntStream.range(0, points.size())
                .forEach(index -> printPoints(points, index));
        System.out.println(EMPTY);
    }

    private void printPoints(List<Boolean> points, int index) {
        System.out.print(LINE);
        if (index == points.size()-1) {
            return;
        }
        System.out.print(LadderState.ofLine(points.get(index)));
    }
}
