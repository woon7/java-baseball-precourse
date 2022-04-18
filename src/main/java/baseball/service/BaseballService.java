package baseball.service;

import baseball.dto.Score;

public interface BaseballService {

    void setRandomDigits();

    void setRandomDigits(String randomDigits);

    Score compareDigits();

    void setDigits(String digits);
}
