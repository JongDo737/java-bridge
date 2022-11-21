package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static String upState;
    static String downState;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @param userState     유저가 입력해온 U or D
     * @param continueGame  게임 종료 or 진행
     * @param isSuccess     종료 일때 성공 or 실패
     *
     */
    public void printMap(List<String> userState, boolean continueGame, boolean isSuccess) {
        initState();
        // 게임 상태를 판단하여 출력
        judgeGameStatement(userState, continueGame, isSuccess);
        // 게임 결과 출력
        printMapResult();

    }

    /**
     * 성공과 실패의 여부에 따라 각각 다른 출력을 제공
     * @param userState     유저가 입력해온 U or D
     * @param continueGame  게임 종료 or 진행
     * @param isSuccess     종료 일때 성공 or 실패
     */
    public static void judgeGameStatement(List<String> userState, boolean continueGame, boolean isSuccess) {
        if (continueGame) {
            printGaming(userState, userState.size(), isSuccess);
        }
        if (!continueGame && isSuccess) {
            printGaming(userState, userState.size(), isSuccess);
        }
        if (!continueGame && !isSuccess) {
            printWrongAndFail(userState, isSuccess);
        }
    }

    public void printResult() {
    }



    public void initState() {
        upState = "[";
        downState = "[";
    }
    // ] 제거 메서드
    public static void replaceClose() {
        upState = upState.replace("]", "");
        downState = downState.replace("]", "");
    }
    public static void isWrongFinished(List<String> userState) {
        if (userState.get(userState.size() - 1).equals("U")) {
            upState += " X ]";
            downState += "   ]";
        }
        if (userState.get(userState.size() - 1).equals("D")) {
            upState += "   ]";
            downState += " X ]";
        }
    }

    public static void isU() {
        upState += " O ";
        downState += "   ";
    }

    public static void isWord(String userStateWord) {
        if (userStateWord == "U") {
            isU();
        }
        if (userStateWord == "D") {
            isD();
        }
    }

    public static void isD() {
        upState += "   ";
        downState += " O ";
    }

    public static void isFinished() {
        upState += "]";
        downState += "]";
    }

    public static void isNotFinished() {
        upState += "|";
        downState += "|";
    }
}