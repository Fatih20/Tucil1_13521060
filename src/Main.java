import lib.io.ToKeyboard;
import lib.solution.Solution;
import lib.ui.Interface;

public class Main {
    public static void main(String[] args) {
        Interface.mainEventLoop();

        // double firstRes = Solution.operate(6, 30, Solution.Operator.MINUS);
        // double secondRes = Solution.operate(6, 6, Solution.Operator.MULTIPLY);

        // ToKeyboard.printNumber((int) Math.round(firstRes));
        // ToKeyboard.printNumber(secondRes);
        // ToKeyboard.printNumber((int) Math.round(Solution.operate(secondRes, firstRes,
        // Solution.Operator.MINUS)));
    }
}
