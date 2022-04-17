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
        String mode;
        do {
            startGame(baseballView.input3Digit());
            mode = baseballView.inputMode();
        } while (mode.equals("1"));
        if (mode.equals("2")) {
            baseballView.exit();
        }
    }

    public void startGame(String digits) {
        baseballService.checkDigits(digits); // 예외처리
        Score score = baseballService.compareDigits(digits);
        baseballView.printScore(score);
    }

}
