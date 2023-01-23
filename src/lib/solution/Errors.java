package lib.solution;

public class Errors {
    static public class IncorrectNumberOfOperand extends Exception {
        public IncorrectNumberOfOperand() {
            super("You may only have 4 operands");
        }
    }

    static public class IncorrectNumberOfOperator extends Exception {
        public IncorrectNumberOfOperator() {
            super("You may only have 3 operator");
        }
    }

}
