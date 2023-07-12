package io.gitgub.yeop.search;

import java.util.Optional;

public class PersonalNumberStorageImpl implements PersonalNumberStorage{
    PersonalNumInfo[] arr;
    int numOfPerInfo;

    public PersonalNumberStorageImpl(int size){
        arr = new PersonalNumInfo[size];
        numOfPerInfo = 0;
    }

    @Override
    public void addPersonalInfo(String name, String perNum) {
        arr[numOfPerInfo] = new PersonalNumInfo(name,perNum);
        numOfPerInfo++;
    }

    @Override
    public Optional<String> searchName(String perNum) {
        for(PersonalNumInfo key : arr){
            if(perNum.compareTo(key.number()) == 0){
                return Optional.of(key.name());
            }
        }
        return Optional.empty();
    }
}
