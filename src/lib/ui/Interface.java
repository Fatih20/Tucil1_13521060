package lib.ui;

import java.util.List;
import java.util.Set;

import lib.io.FromKeyboard;
import lib.io.ToKeyboard;
import lib.io.IOLib;
import lib.io.ToFile;
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
                // Menerima kartu yang digunakan
                String inputRaw = FromKeyboard.readString();
                validationResult = IOLib.inputValidator(inputRaw);
                if (validationResult.message.compareTo("") != 0) {
                    ToKeyboard.printMessage(validationResult.message);
                } else {
                    inputCorrect = true;
                }

            } while (!inputCorrect);

            // Hitung dan cetak solusi
            long startTime = System.currentTimeMillis();
            Set<String> result = Solver.solve(validationResult.cards, target);
            long endTime = System.currentTimeMillis();

            ToKeyboard.printMessage(
                    String.format("Ditemukan %d solusi dalam %d ms.", result.size(), endTime - startTime));
            for (String solution : result) {
                ToKeyboard.printMessage(solution);
            }

            ToKeyboard.printMessage("");

            String saveToFile = FromKeyboard.readString("Ingin menyimpan solusi ke dalam file? (Y/n) ");

            if (saveToFile.toUpperCase().compareTo("Y") == 0) {
                ToKeyboard.printMessage("Masukkan nama file teks tujuan :");
                ToFile.writeToFile(result.stream().toArray(String[]::new));
            }

            ToKeyboard.printMessage("");

            // Tanyakan jika pemain ingin bermain lagi
            String continueAnswer = FromKeyboard.readString("Masukkan 'Y' untuk bermain lagi: ");
            if (continueAnswer.toUpperCase().compareTo("Y") != 0) {
                if (continueAnswer.toUpperCase().compareTo("24") == 0) {
                    ToKeyboard.printMessage("Anda telah kembali ke mode 24");
                    target = 24.0;
                } else if (continueAnswer.toUpperCase().compareTo("060") == 0) {
                    ToKeyboard
                            .printMessage("Anda memasuki mode rahasia 060! Bisa ditebak apa yang dilakukan mode ini.");
                    target = 60.0;
                } else {
                    programRunning = false;
                }
            }
            ToKeyboard.printMessage("");

        }

    }
}
