package io.gitgub.yeop.lotto.console;

import io.gitgub.yeop.lotto.Buy;

public class ConsoleOutput {
    private static final int MINIMUM_BUY_SHEET = 1;
    private static final String BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요. (1_000원 = 1장)";
    private static final String BUY_CONFIRMATION_MESSAGE = "총 %s장을 구매했습니다.";

    public void printBuyAmountMessage() {
        println(BUY_AMOUNT_MESSAGE);
    }

    public void printBuyConfirmationMessage(int buyOfNumber) {
        if (buyOfNumber < MINIMUM_BUY_SHEET) {
            throw new IllegalArgumentException("최소 %d장 이상 구입해야 합니다. (현재 값 %d)".formatted(MINIMUM_BUY_SHEET, buyOfNumber));
        }
        printf(BUY_CONFIRMATION_MESSAGE, buyOfNumber);
        newLine();
    }

    public void printLottoNumbers(Buy results) {
        println(results.stringValue());
    }

    private void println(String msg) {
        System.out.println(msg);
    }

    private void printf(String msg, Object... objects) {
        System.out.printf(msg, objects);
    }

    private void newLine() {
        System.out.println("");
    }
}
