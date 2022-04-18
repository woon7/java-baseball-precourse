package baseball.view;

import baseball.dto.Score;
import baseball.enums.GameMode;

public interface BaseballView {
    String input3Digit();

    GameMode inputMode();

    void exit();

    void printScore(Score score);
}
