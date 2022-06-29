package org.mafideju.ISBNValidator.validators;

public class ValidateISBN {

    public static final int SHORT_ISBN = 10;
    public static final int LONG_ISBN = 13;

    public boolean checkISBN(String isbn) {
        if (isbn.length() == LONG_ISBN) {
            return validate13DigitISBN(isbn);
        } else {
            return validate10DigitISBN(isbn);
        }
    }

    private boolean validate10DigitISBN(String isbn) {
        if (isbn.length() != SHORT_ISBN) throw new NumberFormatException("10 digits issue");
        int total = 0;

        for (int i = 0; i < SHORT_ISBN; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("Not a Number!");
                }
            }
            total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN - i);
        }

        return total % 11 == 0;
    }

    private boolean validate13DigitISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN; i++) {
            if (i % 2 == 0) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }

        return total % 10 == 0;
    }
}
