package io.gitgub.yeop.bankBusiness;

import java.util.Scanner;

public class BankMain {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("계좌를 생성합니다.");
        Account account = new Account(10_000);
        System.out.print("계좌에 입금할 금액을 입력해주세요: ");
        account = account.deposit(scanner.nextInt());
        System.out.println(account);
        System.out.println("계좌에서 출금할 금액을 입력해주세요: ");
        account = account.withDraw(scanner.nextInt());
        System.out.println(account);
    }
}
