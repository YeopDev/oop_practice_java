package io.gitgub.yeop.lotto;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public class Buy {
    private List<Lotto> results;

    public Buy() {
        this.results = new ArrayList<>();
    }

    public void add(Lotto target) {
        results.add(target);
    }

    public String stringValue() {
        return results.stream()
                .map(String::valueOf)
                .collect(joining(lineSeparator()));
    }
}
