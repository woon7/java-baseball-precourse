package baseball.service.impl;

import baseball.dto.Score;
import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class BaseballServiceImpl implements BaseballService {

    private Score score;

    private String digits;

    private String randomDigits;

    @Override
    public void setDigits(String digits) {
        checkDigits(digits); // 예외처리
        this.digits = digits;
    }

    @Override
    public void setRandomDigits() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            builder.append(Randoms.pickNumberInRange(1, 9));
        }
        this.randomDigits = builder.toString();
        checkDuplicateDigits(this.randomDigits);
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

    private void checkDigits(String digits) {
        checkArgLength(digits);
        for (int i = 0; i < digits.length(); i++) {
            checkDigit(digits.charAt(i));
        }
        checkDuplicateDigits(digits);
    }

    @Override
    public Score compareDigits() {
        this.score = new Score();
        findStrike();
        findBall();
        return this.score;
    }

    private boolean isSameDigit(int digitsIndex, int randomDigitsIndex) {
        return this.digits.charAt(digitsIndex) == this.randomDigits.charAt(randomDigitsIndex);
    }

    private void findStrike() {
        for (int i = 0; i < 3; i++) {
            addStrike(i, i);
        }
    }

    private void addStrike(int digitsIndex, int randomDigitsIndex) {
        if (isSameDigit(digitsIndex, randomDigitsIndex)) {
            this.score.addStrike();
        }
    }

    private void findBall() {
        for (int i = 0; i < 3; i++) {
            addBall(i, (i + 1) % 3); // 0 1, 1 2, 2 0
            addBall(i, (i + 2) % 3); // 0 2, 1 0, 2 1
        }
    }

    private void addBall(int digitsIndex, int randomDigitsIndex) {
        if (isSameDigit(digitsIndex, randomDigitsIndex)) {
            this.score.addBall();
        }
    }

}
