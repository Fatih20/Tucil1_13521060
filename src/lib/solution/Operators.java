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

    public boolean isSame(Operators operators) {
        Operator[] ourContent = this.getContent();
        Operator[] theirContent = operators.getContent();

        for (int i = 0; i < 3; i++) {
            if (ourContent[i] != theirContent[i]) {
                return false;
            }
        }
        return true;

    }

    public boolean isReverse(Operators operators) {
        Operator[] ourContent = this.getContent();
        Operator[] theirContent = operators.getContent();

        for (int i = 0; i < 3; i++) {
            if (ourContent[i] != theirContent[theirContent.length - 1 - i]) {
                return false;
            }
        }
        return true;

    }

    /**
     * @param operators
     * @param left
     * @return Apakah operator ini merupakan operator yang diberikan yang
     *         di-shift sesuai parameter
     * 
     */
    public boolean isShifted(Operators operators, boolean left) {
        int increment = left ? -1 : 1;
        Operator[] ourContent = this.getContent();
        Operator[] theirContent = operators.getContent();

        for (int i = 0; i < 3; i++) {
            if (ourContent[i] != theirContent[Math.floorMod(i + increment, 3)]) {
                return false;
            }
        }
        return true;

    }

}
