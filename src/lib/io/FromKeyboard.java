package lib.io;

import java.util.Scanner;

public class FromKeyboard {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Membaca string dari masukan pengguna
     * 
     * @return input dari pengguna dalam string
     */
    static public String readString() {
        String input = scanner.nextLine();
        return input;
    }

    /**
     * Fungsi baca angka generik. Membaca sebuah angka yang dimasukkan user.
     * Mengulangi input jika angka yang dimasukkan berada di luar range yang
     * diberikan
     * 
     * @param numberName nama angka yang dibaca. Teks digunakan untuk user prompt.
     * @param lowerBound batas minimum angka yang boleh
     * @param upperBound batas maksimum angka yang boleh
     * @return integer angka masukan pengguna yang sudah sesuai dengan keperluan
     */
    static public int readInt(String numberName, int lowerBound, int upperBound) {
        int inputtedNumber = 0;
        boolean inputValid = false;
        while (!inputValid) {
            System.out.format("Masukkan %s : ", numberName);
            inputtedNumber = scanner.nextInt();
            inputValid = inputtedNumber >= lowerBound && inputtedNumber <= upperBound;
            if (!inputValid) {
                System.out.format("Bukan %s yang valid, tolong coba lagi%n", numberName);
            }
        }

        scanner.nextLine();

        return inputtedNumber;
    }

    /**
     * Fungsi baca angka generik. Membaca sebuah angka yang dimasukkan user.
     * Mengulangi input jika angka yang dimasukkan berada di bawah lowerBound yang
     * diberikan
     * 
     * @param numberName nama angka yang dibaca. Teks digunakan untuk user prompt.
     * @param lowerBound batas minimum angka yang boleh
     * @return integer angka masukan pengguna yang sudah sesuai dengan keperluan
     */
    static public int readIntWithMinimum(String numberName, int lowerBound) {
        return readInt(numberName, lowerBound, Integer.MAX_VALUE);
    }

    /**
     * Fungsi baca angka generik. Membaca sebuah angka yang dimasukkan user.
     * Mengulangi input jika angka yang dimasukkan berada di atas upperBound yang
     * diberikan
     * 
     * @param numberName nama angka yang dibaca. Teks digunakan untuk user prompt.
     * @param upperBound batas maksimum angka yang boleh
     * @return integer angka masukan pengguna yang sudah sesuai dengan keperluan
     */
    static public int readIntWithMaximum(String numberName, int upperBound) {
        return readInt(numberName, Integer.MIN_VALUE, upperBound);

    }

    /**
     * Fungsi baca angka generik. Membaca sebuah angka yang dimasukkan user.
     * 
     * @param numberName nama angka yang dibaca. Teks digunakan untuk user prompt.
     * @return double angka masukan pengguna yang sudah sesuai dengan keperluan
     */
    static public double readDouble(String numberName) {
        System.out.format("Masukkan %s : ", numberName);
        double inputtedNumber = scanner.nextDouble();

        scanner.nextLine();

        return inputtedNumber;
    }

    /**
     * Fungsi baca string generik. Membaca sebuah string yang dimasukkan user.
     * 
     * @param prompt nama string yang dibaca. Teks digunakan untuk user prompt.
     * @return String masukan pengguna
     */
    static public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
