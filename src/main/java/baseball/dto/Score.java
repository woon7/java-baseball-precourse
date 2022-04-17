package baseball.dto;

public class Score {

    private int strike;

    private int ball;

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public boolean is3Strike() {
        return strike == 3;
    }

    @Override
    public String toString() {
        String result = "낫싱";
        if (ball > 0)
            result = ball + "볼 ";
        if (strike > 0)
            result = result + strike + "스트라이크";
        return result;
    }
}
