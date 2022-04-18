package baseball.dto;

public class Score {

    private int strike;

    private int ball;

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public boolean is3Strike() {
        return this.strike == 3;
    }

    @Override
    public String toString() {
        String result = "낫싱";
        if (this.ball > 0) {
            result = this.ball + "볼 ";
        }
        if (this.strike > 0) {
            result = result + this.strike + "스트라이크";
        }
        return result.trim();
    }
}
