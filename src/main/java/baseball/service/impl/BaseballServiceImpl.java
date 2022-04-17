package baseball.service.impl;

import baseball.dto.Score;
import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class BaseballServiceImpl implements BaseballService {

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
        String randomDigits = get3RandomDigits();
        findStrike(digits, randomDigits);
        return score;
    }

    private int findStrike(String digits, String randomDigits) {
        // TODO : 비교
        return 0;
    }

    private String get3RandomDigits() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            result.append(Randoms.pickNumberInRange(1, 9));
        }
        return result.toString();
    }
}
