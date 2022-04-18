package baseball.service;

import baseball.dto.Score;

public interface BaseballService {

    void setRandomDigits();

    Score compareDigits();

    void setDigits(String digits);
}
