package baseball.service;

import baseball.dto.Score;

public interface BaseballService {

    void setRandomDigits();

    void checkDigits(String digits);

    Score compareDigits(String digits);

}
