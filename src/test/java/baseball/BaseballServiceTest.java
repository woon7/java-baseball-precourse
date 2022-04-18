package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.service.BaseballService;
import baseball.service.impl.BaseballServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballServiceTest {

    private BaseballService baseballService;

    @BeforeEach
    void createBaseballService() {
        baseballService = new BaseballServiceImpl();
    }

    @Test
    @DisplayName("중복된 입력값 예외처리 테스트")
    void setDigits() {
        assertThatThrownBy(() -> {
            baseballService.setDigits("122");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            baseballService.setRandomDigits("676"); // 랜덤값에 중복값이 올 수 있어서 지정값으로 테스트
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3스트라이크 테스트")
    void is3Strike() {
        baseballService.setDigits("123");
        baseballService.setRandomDigits("123"); // 랜덤값에 중복값이 올 수 있어서 지정값으로 테스트
        assertThat(baseballService.compareDigits().is3Strike()).isEqualTo(true);
    }

    @Test
    @DisplayName("1볼 테스트")
    void is1Ball() {
        baseballService.setDigits("123");
        baseballService.setRandomDigits("571"); // 랜덤값에 중복값이 올 수 있어서 지정값으로 테스트
        assertThat(baseballService.compareDigits().toString()).isEqualTo("1볼");
    }

    @Test
    @DisplayName("2볼 1스트라이크 테스트")
    void is2Ball1Strike() {
        baseballService.setDigits("123");
        baseballService.setRandomDigits("321"); // 랜덤값에 중복값이 올 수 있어서 지정값으로 테스트
        assertThat(baseballService.compareDigits().toString()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("낫싱 테스트")
    void isNothing() {
        baseballService.setDigits("123");
        baseballService.setRandomDigits("645"); // 랜덤값에 중복값이 올 수 있어서 지정값으로 테스트
        assertThat(baseballService.compareDigits().toString()).isEqualTo("낫싱");
    }

}
