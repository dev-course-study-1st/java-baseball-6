package baseball.view;

import baseball.model.Hint;
import baseball.utils.constants.GameMessages;

public class OutputView {
    public void printStartMsg() {
        System.out.println(GameMessages.START_MSG.getMessage());
    }
    public void printEndMsg() {
        System.out.println(GameMessages.END_MSG.getMessage());
    }
    public void printHintMsg(Hint hint) {
        System.out.println(hint);
    }
}
