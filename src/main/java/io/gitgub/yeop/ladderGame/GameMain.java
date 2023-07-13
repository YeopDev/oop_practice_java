package io.gitgub.yeop.ladderGame;

import io.gitgub.yeop.ladderGame.controller.GameController;

public class GameMain {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.start();
    }
}
