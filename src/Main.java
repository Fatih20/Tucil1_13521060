import lib.io.ToKeyboard;
import lib.solution.Operands;
import lib.solution.Operators;
import lib.solution.Solution;
import lib.ui.Interface;

public class Main {
    public static void main(String[] args) {
        // Interface.mainEventLoop();

        Solution solution = new Solution(new Operands(4, 7, 8, 9),
                new Operators(Solution.Operator.PLUS, Solution.Operator.DIVIDE, Solution.Operator.PLUS),
                Solution.OperationOrder.LEFTRIGHT);
        System.out.print(solution.getValue());
        // ToKeyboard.printNumber(solution.getValue());
        ToKeyboard.printMessage(solution.getString());
    }
}
