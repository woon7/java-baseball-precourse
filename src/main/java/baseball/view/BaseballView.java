package baseball.view;

import baseball.dto.Score;

public interface BaseballView {
    String input3Digit();

    String inputMode();

    void exit();

    void printScore(Score score);
}
