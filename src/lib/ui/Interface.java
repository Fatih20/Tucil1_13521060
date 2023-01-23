package lib.ui;

import java.util.List;
import java.util.Set;

import lib.io.FromKeyboard;
import lib.io.ToKeyboard;
import lib.io.IOLib;
import lib.io.ValidationResult;
import lib.solver.Solver;

public class Interface {
    static public void mainEventLoop() {
        Boolean programRunning = true;
        while (programRunning) {
            Boolean inputCorrect = false;
            ValidationResult<String, List<String>> validationResult;
            do {
                ToKeyboard.printMessage("Masukkan kartu-kartu yang digunakan :");
                // Receive card
                String inputRaw = FromKeyboard.readString();
                validationResult = IOLib.inputValidator(inputRaw);
                if (validationResult.message.compareTo("") != 0) {
                    ToKeyboard.printMessage(validationResult.message);
                } else {
                    inputCorrect = true;
                }

            } while (!inputCorrect);

            // Compute and print out solution
            // Set<String> result = Solver.Solve(validationResult.cards);
            List<String> result = Solver.solve(validationResult.cards);
            ToKeyboard.printMessage(String.format("Ditemukan %d solusi.\n", result.size()));
            for (String solution : result) {
                ToKeyboard.printMessage(solution);
            }

            // Ask if player would like to play again
            String continueAnswer = FromKeyboard.readString("Masukkan 'Y' untuk bermain lagi: ");
            if (continueAnswer.toUpperCase().compareTo("Y") != 0) {
                programRunning = false;
            }
            ToKeyboard.printMessage("");

        }

    }
}
