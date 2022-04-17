package baseball.controller;

import baseball.dto.Score;
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
        String mode = "1";
        do {
            String digits = baseballView.input3Digit();
            prepareGame(mode, digits);
            Score score = startGame(digits);
            baseballView.printScore(score);
            mode = stopGame(score);
        } while (mode == null || mode.equals("1"));
        baseballView.exit();
    }

    private void prepareGame(String mode, String digits) {
        baseballService.checkDigits(digits); // 예외처리
        if (mode != null && mode.equals("1"))
            baseballService.setRandomDigits();
    }

    private Score startGame(String digits) {
        return baseballService.compareDigits(digits);
    }

    private String stopGame(Score score) {
        if (score.is3Strike())
            return baseballView.inputMode();
        return null;
    }

}
