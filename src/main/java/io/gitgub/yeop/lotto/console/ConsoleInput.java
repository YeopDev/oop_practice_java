package io.gitgub.yeop.lotto.console;

import java.util.Scanner;

public class ConsoleInput {
    private static final int MINIMUM_INPUT = 1_000;
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public int buyAmount() {
        int input = scanner.nextInt();
        if (input < MINIMUM_INPUT) {
            throw new IllegalArgumentException("로또 구입을 위한 지불금액은 최소 %d원 이상 입력해야합니다. (현재 값 %d)".formatted(MINIMUM_INPUT, input));
        }
        return input;
    }
}
