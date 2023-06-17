package io.gitgub.yeop.numberBaseball.user;

import io.gitgub.yeop.numberBaseball.Numbers;
import io.gitgub.yeop.numberBaseball.user.createRandom.RandomNumber;

public record Computer(RandomNumber randomNumber) implements User {
    @Override
    public Numbers value() {
        return randomNumber.AUTO.generator(3);
    }
}
