package baseball.view.impl;

import baseball.view.BaseballView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballViewImpl implements BaseballView {
    @Override
    public String input3Digit() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    @Override
    public String stopGame() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    @Override
    public String exit() {
        return "프로그램을 종료합니다.";
    }

    @Override
    public String inputMode() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String mode = Console.readLine();
        if (mode.equals("1") || mode.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
        return mode;
    }
}
