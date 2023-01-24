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
        double target = 24.0;
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

            long startTime = System.currentTimeMillis();

            // Compute and print out solution
            Set<String> result = Solver.solve(validationResult.cards, target);

            long endTime = System.currentTimeMillis();

            ToKeyboard.printMessage(
                    String.format("Ditemukan %d solusi dalam %d ms.", result.size(), endTime - startTime));
            for (String solution : result) {
                ToKeyboard.printMessage(solution);
            }
            ToKeyboard.printMessage("");

            // Ask if player would like to play again
            String continueAnswer = FromKeyboard.readString("Masukkan 'Y' untuk bermain lagi: ");
            if (continueAnswer.toUpperCase().compareTo("Y") != 0) {
                if (continueAnswer.toUpperCase().compareTo("24") == 0) {
                    ToKeyboard.printMessage("Anda telah kembali ke mode 24");
                    target = 24.0;
                } else if (continueAnswer.toUpperCase().compareTo("69") == 0) {
                    ToKeyboard.printMessage("Anda memasuki mode rahasia 69! Bisa ditebak apa yang dilakukan mode ini.");
                    target = 69.0;
                } else {
                    programRunning = false;
                }
            }
            ToKeyboard.printMessage("");

        }

    }
}
