package lib.solution;

import lib.solution.Solution.Operator;

public class Operators {
    private Operator operator1;
    private Operator operator2;
    private Operator operator3;

    public Operators(Operator operator1, Operator operator2, Operator operator3) {
        this.operator1 = operator1;
        this.operator2 = operator2;
        this.operator3 = operator3;
    }

    public Operator[] getContent() {
        return new Operator[] { this.operator1, this.operator2, this.operator3 };
    }

}
