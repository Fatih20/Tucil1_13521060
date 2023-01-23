package lib.solution;

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

}
