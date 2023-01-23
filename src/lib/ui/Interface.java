package lib.ui;

import java.util.List;

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
            List<String> result = Solver.Solve(validationResult.cards);
            for (String solution : result) {
                ToKeyboard.printMessage(solution);
            }

            // Ask if player would like to play again
            String continueAnswer = FromKeyboard.readString("Masukkan 'Y' untuk bermain lagi:");
            if (continueAnswer.compareTo("Y") != 0) {
                programRunning = false;
            }
            ToKeyboard.printMessage("");

        }

    }
}
