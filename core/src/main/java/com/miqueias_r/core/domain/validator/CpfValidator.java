package com.miqueias_r.core.domain.validator;

import java.util.regex.Pattern;

public class CpfValidator {

    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{11}");

    public static boolean validar(String cpf) {
        if (cpf == null) return false;

        String somenteDigitos = cpf.replaceAll("\\D", "");

        if (!CPF_PATTERN.matcher(somenteDigitos).matches()) return false;

        if (somenteDigitos.chars().distinct().count() == 1) return false;

        try {
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (somenteDigitos.charAt(i) - '0') * (10 - i);
            }
            int digito1 = 11 - (soma % 11);
            if (digito1 >= 10) digito1 = 0;
            if (digito1 != (somenteDigitos.charAt(9) - '0')) return false;

            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (somenteDigitos.charAt(i) - '0') * (11 - i);
            }
            int digito2 = 11 - (soma % 11);
            if (digito2 >= 10) digito2 = 0;

            return digito2 == (somenteDigitos.charAt(10) - '0');

        } catch (Exception e) {
            return false;
        }
    }
}
