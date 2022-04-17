package baseball.service.impl;

import baseball.dto.Score;
import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class BaseballServiceImpl implements BaseballService {

    private String randomDigits;

    @Override
    public void setRandomDigits() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            builder.append(Randoms.pickNumberInRange(1, 9));
        }
        this.randomDigits = builder.toString();
    }

    private void checkDigit(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }

    private void checkArgLength(String arg) {
        if (arg == null || arg.length() != 3) {
            throw new IllegalArgumentException("숫자 3자리를 입력해야 합니다.");
        }
    }

    private void checkDuplicateDigits(String digits) {
        char[] chars = digits.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < digits.length(); i++) {
            addSetAndCheckDuplicate(set, chars[i]);
        }
    }

    private void addSetAndCheckDuplicate(Set set, char c) {
        if (!set.add(c)) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력할 수 있습니다.");
        }
    }

    @Override
    public void checkDigits(String digits) {
        checkArgLength(digits);
        for (int i = 0; i < digits.length(); i++) {
            checkDigit(digits.charAt(i));
        }
        checkDuplicateDigits(digits);
    }

    @Override
    public Score compareDigits(String digits) {
        Score score = new Score();
        findStrike(score, digits);
        findBall(score, digits);
        return score;
    }

    private void findStrike(Score score, String digits) {
        addStrike(score, digits, 0, 0);
        addStrike(score, digits, 1, 1);
        addStrike(score, digits, 2, 2);
    }

    private void addStrike(Score score, String digits, int digitsIndex, int randomDigitsIndex) {
        if (digits.charAt(digitsIndex) == this.randomDigits.charAt(randomDigitsIndex)) {
            score.addStrike();
        }
    }

    private void findBall(Score score, String digits) {
        addBall(score, digits, 0, 1);
        addBall(score, digits, 0, 2);
        addBall(score, digits, 1, 0);
        addBall(score, digits, 1, 2);
        addBall(score, digits, 2, 0);
        addBall(score, digits, 2, 1);
    }

    private void addBall(Score score, String digits, int digitsIndex, int randomDigitsIndex) {
        if (digits.charAt(digitsIndex) == this.randomDigits.charAt(randomDigitsIndex)) {
            score.addBall();
        }
    }

}
