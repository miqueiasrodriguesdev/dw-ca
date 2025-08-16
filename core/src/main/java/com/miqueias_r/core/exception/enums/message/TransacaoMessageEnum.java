package com.miqueias_r.core.exception.enums.message;

public enum TransacaoMessageEnum {
    TRANSACAO_VALOR_NAO_PERMITIDO("Este valor não pode ser transacionado.", 400),
    TRANSACAO_NAO_AUTORIZADO("Este valor não foi autorizado.", 400),
    TRANSACAO_NAO_PERMITIDA("Não é permitido enviar para a mesma carteira.", 400),
    TRANSACAO_CARTEIRA_PAGADOR_NULA("A carteira do pagador não pode ser nula.", 400),
    TRANSACAO_CARTEIRA_RECEBEDOR_NULA("A carteira do recebedor não pode ser nula.", 400);

    private final String message;
    private final int statusCode;

    TransacaoMessageEnum(String message, int statusCode) {
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
