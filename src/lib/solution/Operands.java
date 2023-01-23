package lib.solution;

import lib.io.ToKeyboard;
import lib.solution.Solution.Operator;

public class Operands {
    private double operand1;
    private double operand2;
    private double operand3;
    private double operand4;

    public Operands(double operand1, double operand2, double operand3, double operand4) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operand3 = operand3;
        this.operand4 = operand4;
    }

    public double[] getContent() {
        return new double[] { this.operand1, this.operand2, this.operand3, this.operand4 };
    }

    public void printContent() {
        ToKeyboard.printNumber(this.operand1);
        ToKeyboard.printNumber(this.operand2);
        ToKeyboard.printNumber(this.operand3);
        ToKeyboard.printNumber(this.operand4);
    }

    public boolean isReverse(Operands operands) {
        double[] ourContent = this.getContent();
        double[] theirContent = operands.getContent();

        for (int i = 0; i < 4; i++) {
            if (ourContent[i] != theirContent[theirContent.length - 1 - i]) {
                return false;
            }
        }
        return true;

    }

    public boolean isSame(Operands operands) {
        double[] ourContent = this.getContent();
        double[] theirContent = operands.getContent();

        for (int i = 0; i < 4; i++) {
            if (ourContent[i] != theirContent[i]) {
                return false;
            }
        }
        return true;

    }

    /**
     * @param operators
     * @param left
     * @return Apakah operand ini merupakan operand yang diberikan yang
     *         di-shift sesuai parameter
     * 
     */
    public boolean isShifted(Operands operands, boolean left) {
        int increment = left ? -1 : 1;
        double[] ourContent = this.getContent();
        double[] theirContent = operands.getContent();

        for (int i = 0; i < 4; i++) {
            if (ourContent[i] != theirContent[Math.floorMod(i + increment, 4)]) {
                return false;
            }
        }
        return true;

    }

}
