package lib.io;

public class ValidationResult<F, S> {
    public F message;
    public S cards;

    /**
     * Membuat sebuah tuple dua anggota (pair) dengan message sebagai elemen pertama
     * dan cards sebagai elemen
     * kedua.
     * 
     * @param message
     * @param cards
     */
    public ValidationResult(F message, S cards) {
        this.message = message;
        this.cards = cards;
    }
}