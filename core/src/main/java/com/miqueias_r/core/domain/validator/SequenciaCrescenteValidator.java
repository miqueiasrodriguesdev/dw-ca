package com.miqueias_r.core.domain.validator;

public class SequenciaCrescenteValidator {

    public static boolean validar(String numero) {
        if (numero == null || numero.length() < 2) {
            return false;
        }

        if (!numero.matches("\\d+")) {
            return false;
        }

        for (int i = 0; i < numero.length() - 1; i++) {
            if (numero.charAt(i + 1) != numero.charAt(i) + 1) {
                return false;
            }
        }

        return true;
    }
}
