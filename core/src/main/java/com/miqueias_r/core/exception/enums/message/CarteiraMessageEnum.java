package com.miqueias_r.core.exception.enums.message;

public enum CarteiraMessageEnum {
    CARTEIRA_NAO_ENCONTRADO("Não encontramos sua carteira.", 404),

    CARTEIRA_NAO_TEM_SALDO_SUFICIENTE("Saldo insuficiente na carteira para realizar esta operação.", 400),
    CARTEIRA_NAO_TEM_METODO("Método de pagamento solicitado não está disponível na carteira.", 400),
    CARTEIRA_VALOR_NAO_PERMITIDO("Este valor não pode ser transferido ou adicionado à carteira.", 400),

    CARTEIRA_USUARIO_NULO("Usuário não pode ser nulo.", 400),
    CARTEIRA_PIN_NULO("O PIN não pode ser nulo.", 400),
    CARTEIRA_PIN_INVALIDO("O PIN é inválido",400),
    CARTEIRA_PIN_INCORRETO("O PIN está incorreto",400),
    CARTEIRA_PIN_SEQUENCIA_INVALIDA("O PIN não pode conter sequência numérica crescente ou decrescente.", 400),
    CARTEIRA_SALDO_NULO("Saldo da carteira não pode ser nulo.", 400);

    private final String message;
    private final int statusCode;

    CarteiraMessageEnum(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
