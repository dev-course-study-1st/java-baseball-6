package baseball.utils.view;

public class ConsoleView {
    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumbers() {
        System.out.print("숫자를 입력하세요 : ");
    }

    public static void printRetryOrNot() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printResult(int strike, int ball, StringBuilder sb) {
        if(ball != 0) {
            sb.append(ball).append("볼").append(" ");
        }

        if(strike != 0) {
            sb.append(strike).append("스트라이크");
        }

        if(sb.isEmpty()) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
    }
}
