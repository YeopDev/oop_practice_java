package io.gitgub.yeop.numberBaseball;

import io.gitgub.yeop.numberBaseball.user.Computer;
import io.gitgub.yeop.numberBaseball.user.createRandom.RandomNumber;
import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    void computerCreateValue() {
        Computer computer = new Computer(size -> RandomNumber.AUTO.generator(3));
        System.out.println("computer가 생성한 값: %s".formatted(computer.value()));
    }
}