package baseball.controller;

import baseball.dto.Score;
import baseball.enums.GameMode;
import baseball.service.BaseballService;
import baseball.view.BaseballView;

public class BaseballController {

    private final BaseballService baseballService;

    private final BaseballView baseballView;

    public BaseballController(BaseballService baseballService, BaseballView baseballView) {
        this.baseballService = baseballService;
        this.baseballView = baseballView;
    }

    public void run() {
        GameMode mode = GameMode.NEW_GAME;
        do {
            prepareGame(mode);
            mode = stopGame(startGame());
        } while (mode == GameMode.RETRY || mode == GameMode.NEW_GAME);
        exit();
    }

    private void exit() {
        baseballView.exit();
    }

    private void prepareGame(GameMode mode) {
        baseballService.setDigits(baseballView.input3Digit());
        if (mode == GameMode.NEW_GAME) {
            baseballService.setRandomDigits();
        }
    }

    private Score startGame() {
        return baseballService.compareDigits();
    }

    private GameMode stopGame(Score score) {
        baseballView.printScore(score);
        if (score.is3Strike()) {
            return baseballView.inputMode();
        }
        return GameMode.RETRY;
    }

}
