package io.gitgub.yeop.ladderGame.view;

import io.gitgub.yeop.ladderGame.destination.Destination;
import io.gitgub.yeop.ladderGame.person.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PERSON_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분합니다.)";
    private static final String INPUT_LADDER_SIZE = "사다리 높이를 입력해주세요. (사다리 SIZE)";
    private static final String INPUT_DESTINATION_INFO = "도착지 정보를 입력해주세요. (정보는 쉼표(,)로 구분합니다.)";
    private static final String EMPTY_ERROR = "정보가 없습니다. (현재 값 %s)";
    private static Scanner scanner = new Scanner(System.in);

    public List<Person> personList() {
        System.out.println(INPUT_PERSON_NAME);
        return createPersonList(scanner.nextLine());
    }

    public List<Person> createPersonList(String person) {
        isEmpty(person);
        return Arrays.stream(person.split(","))
                .map(Person::new)
                .toList();
    }

    public int ladderSize() {
        System.out.println(INPUT_LADDER_SIZE);
        return scanner.nextInt();
    }

    public List<Destination> destinationList() {
        System.out.println(INPUT_DESTINATION_INFO);
        scanner.nextLine();
        return createDestinationList(scanner.nextLine());
    }

    public List<Destination> createDestinationList(String destination) {
        isEmpty(destination);
        return Arrays.stream(destination.split(","))
                .map(Destination::new)
                .toList();
    }

    private void isEmpty(String info) {
        if (info == null || info.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR.formatted(info));
        }
    }
}
