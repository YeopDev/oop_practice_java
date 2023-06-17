package io.gitgub.yeop.numberBaseball.user;

import io.gitgub.yeop.numberBaseball.Numbers;
import io.gitgub.yeop.numberBaseball.user.User;

public record Player(String input) implements User {
    @Override
    public Numbers value() {
        return new Numbers(input);
    }
}
