package lib.ui;

import java.util.List;

import lib.io.FromKeyboard;
import lib.io.ToKeyboard;
import lib.io.IOLib;
import lib.io.ValidationResult;

public class Interface {
    static public void mainEventLoop() {
        Boolean programRunning = true;
        while (programRunning) {
            Boolean inputCorrect = false;
            while (!inputCorrect) {
                ToKeyboard.printMessage("Masukkan kartu-kartu yang digunakan :");
                // Receive card
                String inputRaw = FromKeyboard.readString();
                ValidationResult<String, List<String>> validationResult = IOLib.inputValidator(inputRaw);
                if (validationResult.message.compareTo("") != 0) {
                    ToKeyboard.printMessage(validationResult.message);
                }
            }

            // Compute and print out solution

            // Ask if player would like to play again
            String continueAnswer = FromKeyboard.readString("Masukkan 'Y' untuk bermain lagi:");
            if (continueAnswer.compareTo(continueAnswer) != 0) {
                programRunning = false;
            }
            ToKeyboard.printMessage("\n");

        }

    }
}
