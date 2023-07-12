package io.gitgub.yeop.search;

import java.util.Optional;

public interface PersonalNumberStorage {
    void addPersonalInfo(String name, String perNum);
    Optional<String> searchName(String perNum);
}
