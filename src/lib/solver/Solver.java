package lib.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lib.solution.Operands;
import lib.solution.Operators;
import lib.solution.Solution;
import lib.solution.Solution.OperationOrder;
import lib.solution.Solution.Operator;

public class Solver {

    static private List<Operands> operandsMaker(List<String> givenCards) {
        HashMap<String, Double> cardValues = new HashMap<String, Double>();
        cardValues.put("A", 1.0);
        cardValues.put("2", 2.0);
        cardValues.put("3", 3.0);
        cardValues.put("4", 4.0);
        cardValues.put("5", 5.0);
        cardValues.put("6", 6.0);
        cardValues.put("7", 7.0);
        cardValues.put("8", 8.0);
        cardValues.put("9", 9.0);
        cardValues.put("10", 10.0);
        cardValues.put("J", 11.0);
        cardValues.put("Q", 12.0);
        cardValues.put("K", 13.0);

        List<Double> translatedCards = new ArrayList<Double>();

        for (int i = 0; i < 4; i++) {
            translatedCards.add(cardValues.get(givenCards.get(i)));
        }

        List<Operands> operandPermutation = new ArrayList<Operands>();

        List<Double> remainingCards = new ArrayList<Double>(translatedCards);
        for (int i = 0; i < 4; i++) {
            // List<Double> remainingCards = new ArrayList<Double>(translatedCards);
            List<Double> remainingCards1 = new ArrayList<Double>(remainingCards);
            Double operand1 = remainingCards1.remove(i);
            for (int j = 0; j < 3; j++) {
                List<Double> remainingCards2 = new ArrayList<Double>(remainingCards1);
                Double operand2 = remainingCards2.remove(j);
                for (int k = 0; k < 2; k++) {
                    List<Double> remainingCards3 = new ArrayList<Double>(remainingCards2);
                    Double operand3 = remainingCards3.remove(k);
                    for (int l = 0; l < 1; l++) {
                        // ToKeyboard.printMessage(Arrays.toString(remainingCards.toArray()));
                        Double operand4 = remainingCards3.remove(l);
                        operandPermutation.add(new Operands(operand1, operand2, operand3, operand4));
                    }

                }

            }
        }
        return operandPermutation;
    }

    static private List<Operators> operatorsMaker() {
        List<Operators> operatorPermutation = new ArrayList<Operators>();
        Operator[] operatorArray = Operator.values();

        for (Operator operator1 : operatorArray) {
            for (Operator operator2 : operatorArray) {
                for (Operator operator3 : operatorArray) {
                    operatorPermutation.add(new Operators(operator1, operator2, operator3));
                }
            }
        }
        return operatorPermutation;
    }

    static public Set<String> solve(List<String> givenCards, double target) {
        List<OperationOrder> operationOrderArray = Arrays.asList(OperationOrder.values());

        Set<String> possibleSolutions = new HashSet<String>();
        // Set<String> result = new HashSet<String>();

        // long startOPRPerm = System.currentTimeMillis();
        List<Operands> operandPermutation = operandsMaker(givenCards);
        // long endOPRPerm = System.currentTimeMillis();
        List<Operators> operatorPermutation = operatorsMaker();
        // long endOPPerm = System.currentTimeMillis();

        for (Operands operands : operandPermutation) {
            for (Operators operators : operatorPermutation) {
                for (OperationOrder operationOrder : operationOrderArray) {
                    Solution possibleSolution = new Solution(operands, operators,
                            operationOrder);
                    if (possibleSolution.compareValue(target)) {
                        possibleSolutions.add(possibleSolution.getString());
                    }
                }
            }
        }

        // long endSolPerm = System.currentTimeMillis();

        // ToKeyboard.printNumber(endOPRPerm - startOPRPerm, "Operands Permutation ");
        // ToKeyboard.printNumber(endOPPerm - endOPRPerm, "Operator Permutation ");
        // ToKeyboard.printNumber(endSolPerm - endOPPerm, "Solution Permutation ");

        return possibleSolutions;
    }

    static public Set<String> solve(List<String> givenCards) {
        return solve(givenCards, 24.0);
    }

}
