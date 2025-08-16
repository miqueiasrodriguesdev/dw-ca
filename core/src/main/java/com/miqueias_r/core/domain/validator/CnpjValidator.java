package com.miqueias_r.core.domain.validator;

import java.util.regex.Pattern;

public class CnpjValidator {

    private static final Pattern CNPJ_PATTERN = Pattern.compile("\\d{14}");

    public static boolean validar(String cnpj) {
        if (cnpj == null) return false;

        String somenteDigitos = cnpj.replaceAll("\\D", "");

        if (!CNPJ_PATTERN.matcher(somenteDigitos).matches()) return false;

        if (somenteDigitos.chars().distinct().count() == 1) return false;

        try {
            int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

            int soma = 0;
            for (int i = 0; i < 12; i++) {
                soma += (somenteDigitos.charAt(i) - '0') * pesos1[i];
            }
            int digito1 = soma % 11;
            digito1 = digito1 < 2 ? 0 : 11 - digito1;
            if (digito1 != (somenteDigitos.charAt(12) - '0')) return false;

            // Segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 13; i++) {
                soma += (somenteDigitos.charAt(i) - '0') * pesos2[i];
            }
            int digito2 = soma % 11;
            digito2 = digito2 < 2 ? 0 : 11 - digito2;

            return digito2 == (somenteDigitos.charAt(13) - '0');

        } catch (Exception e) {
            return false;
        }
    }
}
