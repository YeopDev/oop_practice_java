package io.gitgub.yeop.ladderGame.controller;

import io.gitgub.yeop.ladderGame.destination.Destination;
import io.gitgub.yeop.ladderGame.domain.Ladder;
import io.gitgub.yeop.ladderGame.person.Person;
import io.gitgub.yeop.ladderGame.view.InputView;
import io.gitgub.yeop.ladderGame.view.ResultView;

import java.util.List;

public class GameController {
    public void start() {
        InputView inputView = new InputView();
        List<Person> personList = inputView.personList();
        int ladderSize = inputView.ladderSize();
        List<Destination> destinationList = inputView.destinationList();

        Ladder ladder = new Ladder(ladderSize, personList.size());

        ResultView resultView = new ResultView();
        resultView.printPerson(personList);
        resultView.printLadder(ladder);
    }
}
