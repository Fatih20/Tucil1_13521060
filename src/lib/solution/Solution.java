package lib.solution;

import lib.io.ToKeyboard;
import lib.solution.Errors.IncorrectNumberOfOperand;
import lib.solution.Errors.IncorrectNumberOfOperator;

public class Solution {
    private Operands operands;
    private Operators operator;
    private OperationOrder operationOrder;

    public enum Operator {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private String symbol;

        private Operator(String symbol) {
            this.symbol = symbol;
        };

        public String getSymbol() {
            return this.symbol;
        }
    }

    // LEFTRIGHT
    // ((X X) (X X))
    // LEFTFIRST
    // (((X X) X) X)
    // RIGHTFIRST
    // (X (X(X X)))
    // MIDDLERIGHT
    // (X ((X X) X))
    // MIDDLELEFT
    // ((X (X X)) X)

    public enum OperationOrder {
        LEFTRIGHT,
        LEFTFIRST,
        RIGHTFIRST,
        MIDDLERIGHT,
        MIDDLELEFT,
    }

    public Solution(Operands operands,
            Operators operator,
            OperationOrder operationOrder) {

        this.operands = operands;
        this.operator = operator;
        this.operationOrder = operationOrder;
    }

    public void setOperand(Operands operands) {
        this.operands = operands;
    }

    public void setOperator(Operators operator) throws IncorrectNumberOfOperator {

        this.operator = operator;
    }

    public void setOperationOrder(OperationOrder operationOrder) {
        this.operationOrder = operationOrder;
    }

    public Operands getOperand() {
        return this.operands;
    }

    public Operators getOperator() {
        return this.operator;
    }

    public OperationOrder getOperationOrder() {
        return this.operationOrder;
    }

    public boolean isIdentical(Solution solution) {
        if (this.operands.isSame(solution.getOperand()) && this.operator.isSame(solution.getOperator())
                && this.operationOrder == solution.operationOrder) {
            return true;
        }

        if (this.operands.isReverse(solution.getOperand())) {
            if (this.operationOrder == OperationOrder.LEFTFIRST
                    && solution.operationOrder == OperationOrder.RIGHTFIRST) {
                return true;
            } else if (this.operationOrder == OperationOrder.RIGHTFIRST
                    && solution.operationOrder == OperationOrder.LEFTFIRST) {
                return true;
            }
        }

        return false;
    }

    static public double operate(double operand1, double operand2, Operator operator) {
        double result;
        switch (operator) {
            case PLUS:
                result = operand1 + operand2;
                break;
            case DIVIDE:
                result = operand1 / operand2;
                break;
            case MINUS:
                result = operand1 - operand2;
                break;
            case MULTIPLY:
                result = operand1 * operand2;
                break;
            default:
                result = operand1 + operand2;
                break;
        }
        return result;
    }

    public double getValue() {
        double result = 0;
        double[] operands = this.operands.getContent();
        Operator[] operator = this.operator.getContent();

        // LEFTRIGHT
        // ((X X) (X X))
        // LEFTFIRST
        // (((X X) X) X)
        // RIGHTFIRST
        // (X (X(X X)))
        // MIDDLERIGHT
        // (X ((X X) X))
        // MIDDLELEFT
        // ((X (X X)) X)

        switch (this.operationOrder) {
            case LEFTRIGHT:
                double left = operate(operands[0], operands[1], operator[0]);
                double right = operate(operands[2], operands[3], operator[2]);
                result = operate(left, right, operator[1]);
                break;
            case LEFTFIRST:
                double firstLeft = operate(operands[0], operands[1], operator[0]);
                double nextLeft = operate(firstLeft, operands[2], operator[1]);
                result = operate(nextLeft, operands[3], operator[2]);
                break;
            case RIGHTFIRST:
                double firstRight = operate(operands[2], operands[3], operator[2]);
                double nextRight = operate(operands[1], firstRight, operator[1]);
                result = operate(operands[0], nextRight, operator[0]);
                break;
            case MIDDLELEFT:
                double middleLeft = operate(operands[1], operands[2], operator[1]);
                double leftmost = operate(operands[0], middleLeft, operator[0]);
                result = operate(leftmost, operands[3], operator[2]);
                break;
            case MIDDLERIGHT:
                double middleRight = operate(operands[1], operands[2], operator[1]);
                double rightmost = operate(middleRight, operands[3], operator[2]);
                result = operate(operands[0], rightmost, operator[0]);
                break;
        }

        return result;
    }

    public boolean compareValue(double value) {
        return Math.abs(this.getValue() - value) <= 1 / 170;
    }

    public String getString() {
        String stringFormat = "";
        double[] operands = this.operands.getContent();
        Operator[] operator = this.operator.getContent();

        // LEFTRIGHT
        // ((X X) (X X))
        // LEFTFIRST
        // (((X X) X) X)
        // RIGHTFIRST
        // (X (X(X X)))
        // MIDDLERIGHT
        // (X ((X X) X))
        // MIDDLELEFT
        // ((X (X X)) X)

        switch (this.operationOrder) {
            case LEFTRIGHT:
                stringFormat = "(%d %s %d) %s (%d %s %d)";
                break;
            case LEFTFIRST:
                stringFormat = "(((%d %s %d) %s %d) %s %d)";
                break;
            case RIGHTFIRST:
                stringFormat = "(%d %s (%d %s (%d %s %d)))";
                break;
            case MIDDLELEFT:
                stringFormat = "((%d %s (%d %s %d)) %s %d)";
                break;

            case MIDDLERIGHT:
                stringFormat = "(%d %s ((%d %s %d) %s %d))";
                break;
        }

        String result = String.format(stringFormat, (int) Math.round(operands[0]), operator[0].getSymbol(),
                (int) Math.round(operands[1]), operator[1].getSymbol(), (int) Math.round(operands[2]),
                operator[2].getSymbol(), (int) Math.round(operands[3]));
        return result;
    }

}
