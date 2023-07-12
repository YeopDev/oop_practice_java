package io.gitgub.yeop.search;

public class PersonalNumberMain {
    public static void main(String[] args) {
        PersonalNumberStorage storage = new PersonalNumberStorageImpl(100);
        storage.addPersonalInfo("김길동", "950000-1122333");
        storage.addPersonalInfo("홍길동", "970000-1122334");

        System.out.println(storage.searchName("950000-1122333").get());
        System.out.println(storage.searchName("970000-1122334").get());
    }
}
