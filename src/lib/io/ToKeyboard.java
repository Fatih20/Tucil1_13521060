package lib.io;

public class ToKeyboard {
    /**
     * Mencetak angka double bersama sebuah pesan ke layar
     * <p>
     * I.S. number double terdefinisi, message terdefinisi
     * <p>
     * F.S. tercetak ke layar angka message dan number tanpa dipisahkan spasi
     */
    static public void printNumber(double number, String message) {
        System.out.printf("%s%f%n", message, number);
    }

    /**
     * Mencetak angka double
     * <p>
     * I.S. number double terdefinisi
     * <p>
     * F.S. tercetak ke layar angka
     */
    static public void printNumber(double number) {
        System.out.printf("%f%n", number);
    }

    /**
     * Mencetak sebuah string
     * <p>
     * I.S. message terdefinisi
     * <p>
     * F.S. tercetak ke layar sebuah string
     */
    static public void printMessage(String message) {
        System.out.printf("%s%n", message);
    }

    public static void clearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name"); // Check the current operating system

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
