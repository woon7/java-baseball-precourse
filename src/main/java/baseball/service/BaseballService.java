package baseball.service;

import baseball.dto.Score;

public interface BaseballService {

    void checkDigits(String digits);

    Score compareDigits(String digits);
}
