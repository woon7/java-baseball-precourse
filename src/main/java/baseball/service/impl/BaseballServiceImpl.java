package baseball.service.impl;

import baseball.service.BaseballService;

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

    @Override
    public void checkDigits(String digits) {
        checkArgLength(digits);
        for (int i = 0; i < digits.length(); i++) {
            checkDigit(digits.charAt(i));
        }
    }

}
