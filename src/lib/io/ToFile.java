package lib.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ToFile {

    /**
     * Status pemenuhan request pembuatan file, apakah file sudah ada, sudah
     * berhasil dibuat, atau terdapat error lain.
     */
    static public class CreateFileCondition {
        private boolean createFileSuccessful;
        private boolean fileAlreadyExists;

        public CreateFileCondition() {
            this.createFileSuccessful = false;
            this.fileAlreadyExists = false;
        }

        public void setCreateSuccessful(boolean newValue) {
            createFileSuccessful = newValue;
        }

        public void setCreateSuccessful() {
            createFileSuccessful = true;
        }

        public void setFileExists(boolean newValue) {
            fileAlreadyExists = newValue;
        }

        public void setFileExists() {
            fileAlreadyExists = true;
        }

        public boolean otherError() {
            return !createFileSuccessful && !fileAlreadyExists;
        }

        public boolean isSuccessful() {
            return createFileSuccessful;
        }

        public boolean isExists() {
            return fileAlreadyExists;
        }

    }

    /**
     * Mencoba membuat file dan mengembalikan status pembuatannya (apakah berhasil,
     * error, dsb.)
     * 
     * @param filename nama file yang dibuat
     * @return status permintaan pembuatan file
     */
    private static CreateFileCondition createFileSuccessful(String filename) {
        CreateFileCondition createFileCondition = new CreateFileCondition();
        try {
            File outputtedFile = new File(filename);
            if (outputtedFile.createNewFile()) {
                createFileCondition.setCreateSuccessful();
            } else {
                createFileCondition.setFileExists();
            }
        } catch (IOException e) {
            ToKeyboard.printMessage(e.getMessage());
        }
        return createFileCondition;
    }

    /**
     * Meminta nama file yang valid dan bisa dibuat dari pengguna
     * 
     * @return
     */
    private static String getValidFilename() {
        String filename = "../result/" + FromKeyboard.readString() + ".txt";
        CreateFileCondition createFileCondition = createFileSuccessful(filename);
        while (!createFileCondition.isSuccessful()) {
            String errorMessage = "";

            if (createFileCondition.isExists()) {
                errorMessage = "File dengan nama sama sudah ada. Coba ulangi lagi dengan nama file lain.";
            }

            if (createFileCondition.otherError()) {
                errorMessage = "File tidak dapat dibuat karena suatu hal. Mohon coba lagi.";
            }
            ToKeyboard.printMessage(errorMessage);
            filename = FromKeyboard.readString();
            createFileCondition = createFileSuccessful(filename);
        }

        return filename;
    }

    /**
     * Menuliskan rowString ke dalam file teks. File yang mana yang ditulisi akan
     * dimintakan kepada pengguna.
     * 
     * @param rowStrings baris teks yang ditulis ke dalam file
     */
    public static void writeToFile(String[] rowStrings) {
        String filename = getValidFilename();

        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            for (int i = 0; i < rowStrings.length; i++) {
                fileWriter.write(rowStrings[i] + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            String errorMessage = "File tidak dapat ditulis karena suatu hal. Mohon coba lagi.";
            ToKeyboard.printMessage(errorMessage);

        }

    }
}
