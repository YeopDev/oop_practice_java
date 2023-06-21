package io.gitgub.yeop.lotto;

import io.gitgub.yeop.lotto.console.ConsoleInput;
import io.gitgub.yeop.lotto.console.ConsoleOutput;
import io.gitgub.yeop.lotto.create.CreateLottoNumbers;

public class LottoMachine {
    private static final int MINIMUM_SIZE_NUMBERS = 6;
    private static final int ONE_SHEET_PRICE = 1_000;

    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        ConsoleOutput output = new ConsoleOutput();
        Buy buy = new Buy();

        output.printBuyAmountMessage();
        try{
            int purchaseAmount = input.buyAmount();
            int buyFewSheets = purchaseAmount / ONE_SHEET_PRICE;
            output.printBuyConfirmationMessage(buyFewSheets);

            for(int i = 0; i < buyFewSheets; i++){
                buy.add(new Lotto(CreateLottoNumbers.AUTO.create(MINIMUM_SIZE_NUMBERS)));
            }
        }catch (IllegalArgumentException msg){
            System.out.println(msg.getMessage());
        }

        output.printLottoNumbers(buy);
    }
}
