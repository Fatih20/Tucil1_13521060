package lib.solution;

import lib.solution.Solution.Operator;

public class Operators {
    private Operator operator1;
    private Operator operator2;
    private Operator operator3;

    /**
     * Menginisiasi operators
     * 
     * @param operator1
     * @param operator2
     * @param operator3
     */
    public Operators(Operator operator1, Operator operator2, Operator operator3) {
        this.operator1 = operator1;
        this.operator2 = operator2;
        this.operator3 = operator3;
    }

    /**
     * Mengembalikan semua operator dalam sebuah array of double
     * 
     * @return array berisi semua operator
     */
    public Operator[] getContent() {
        return new Operator[] { this.operator1, this.operator2, this.operator3 };
    }

}
