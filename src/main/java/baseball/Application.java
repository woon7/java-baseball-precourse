package baseball;

import baseball.controller.BaseballController;
import baseball.service.impl.BaseballServiceImpl;
import baseball.view.impl.BaseballViewImpl;

public class Application {

    private final BaseballController baseballController;

    private Application(BaseballController baseballController) {
        this.baseballController = baseballController;
    }

    private void run() {
        baseballController.run();
    }

    public static void main(String[] args) {
        new Application(new BaseballController(new BaseballServiceImpl(), new BaseballViewImpl())).run();
    }

}
