package io.gitgub.yeop.numberBaseball;

import io.gitgub.yeop.numberBaseball.user.Computer;
import io.gitgub.yeop.numberBaseball.user.User;
import io.gitgub.yeop.numberBaseball.user.createRandom.RandomNumber;

import java.util.Scanner;

public class BaseBallMain {
    private static final int SIZE = 3;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        User computer = new Computer(value -> RandomNumber.AUTO.generator(SIZE));
        Numbers computerPick = computer.value();

        while (true) {
            System.out.println("computerPick = " + computerPick);
            System.out.print("숫자 %d개를 입력해주세요 : ".formatted(SIZE));
            Numbers numbers = new Numbers(scanner.nextLine());
            int strike = numbers.strike(computerPick);
            int ball = numbers.ball(computerPick);

            if (strike == 3) {
                System.out.println("숫자 3개를 전부 맞췄습니다. (계속진행 Y, 게임종료 N)");
                String flag = scanner.nextLine();
                if (flag.equalsIgnoreCase("Y")) {
                    computerPick = computer.value();
                    continue;
                }
                if (flag.equalsIgnoreCase("N")) {
                    System.out.println("게임이 종료됩니다.");
                    break;
                }
            }
            System.out.println("strike : %d개 , ball : %d개 맞췄습니다. 다시 입력해주세요.".formatted(strike, ball));
        }
    }
}
