package lib.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ToFile {

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
        }
        return createFileCondition;
    }

    private static String getValidFilename() {
        String filename = FromKeyboard.readString();
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
