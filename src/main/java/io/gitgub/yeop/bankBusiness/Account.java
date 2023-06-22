package io.gitgub.yeop.bankBusiness;

import java.text.DecimalFormat;

public record Account(int balance) {
    private static final int MINIMUM_BALANCE = 0;
    private static final int MINIMUM_MONEY = 1_000;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###원");

    public Account {
        validate(balance);
    }

    public Account deposit(int money) {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException("입금 시 최소 단위는 %d원 부터 입니다. (현재 값 %d)".formatted(MINIMUM_MONEY, money));
        }
        return new Account(this.balance + money);
    }

    public Account withDraw(int money) {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException("출금 시 최소 단위는 %d원 부터 입니다. (현재 값 %d)".formatted(MINIMUM_MONEY, money));
        }
        return new Account(this.balance - money);
    }

    @Override
    public String toString() {
        return "잔고: " + DECIMAL_FORMAT.format(balance);
    }

    private void validate(int balance) {
        if (balance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("계좌생성 시 잔고는 %d원 보다 작을 수 없습니다. (현재 값 %d)".formatted(MINIMUM_BALANCE, balance));
        }
    }
}
