package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("게임 종료 후 재시작")
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    @DisplayName("입력값이 3자리가 넘어가는 경우")
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값에 문자가 들어가는 경우")
    void runWithChar() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1R1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값에 공백이 있는 경우")
    void runWithEmpty() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 3 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값이 서로 다른 숫자가 아닌 경우")
    void runWithDuplicateDigits() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 게임종료_후_재시작()과 같이 테스트 돌리면 Randoms.pickNumberInRange()가 제대로 동작하지 않음
//    @Test
//    @DisplayName("랜덤값이 서로 다른 숫자가 아닌 경우")
//    void runWithDuplicateRandomDigits() {
//        assertRandomNumberInRangeTest(
//                () -> assertThatThrownBy(() -> runException("246", "135", "1", "597", "589", "2"))
//                        .isInstanceOf(IllegalArgumentException.class),
//                1, 3, 5, 5, 5, 5
//        );
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
