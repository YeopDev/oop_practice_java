package io.gitgub.yeop.bankBusiness;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class AccountTest {
    private Account account;

    @ParameterizedTest
    @ValueSource(ints = {10_000})
    @DisplayName("계좌를_생성한다_성공")
    void createAccountNoThrownBy(int money) {
        assertThatCode(() -> new Account(money)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1})
    @DisplayName("계좌를_생성한다_실패")
    void createAccountThrownBy(int money) {
        assertThatThrownBy(() -> new Account(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("계좌생성 시 잔고는 %d원 보다 작을 수 없습니다. (현재 값 %d)".formatted(0, money));
    }

    @ParameterizedTest
    @ValueSource(ints = {10_000})
    @DisplayName("계좌에_돈을_입금한다_성공")
    void depositNoThrownBy(int money) {
        assertThatCode(
                () -> {
                    account = new Account(money);
                    account = account.deposit(1_000);
                    assertThat(account.balance()).isEqualTo(11_000);
                }
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {10_000})
    @DisplayName("계좌에_돈을_입금한다_실패")
    void depositThrownBy(int money) {
        assertThatThrownBy(
                () -> {
                    account = new Account(money);
                    account = account.deposit(900);
                    assertThat(account.balance()).isEqualTo(10_000);
                }
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("입금 시 최소 단위는 %d원 부터 입니다. (현재 값 %d)".formatted(1_000, 900));
    }

    @ParameterizedTest
    @ValueSource(ints = {10_000})
    @DisplayName("계좌에_돈을_출금한다_성공")
    void withDrawNoThrownBy(int money) {
        assertThatCode(
                () -> {
                    account = new Account(money);
                    account = account.withDraw(1_000);
                    assertThat(account.balance()).isEqualTo(9_000);
                }
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {10_000})
    @DisplayName("계좌에_돈을_출금한다_실패")
    void withDrawThrownBy(int money) {
        assertThatThrownBy(
                () -> {
                    account = new Account(money);
                    account = account.withDraw(900);
                    assertThat(account.balance()).isEqualTo(10_000);
                }
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("출금 시 최소 단위는 %d원 부터 입니다. (현재 값 %d)".formatted(1_000, 900));
    }
}