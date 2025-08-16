package com.miqueias_r.infrastructure.exception.enums.message;

public enum ServicoExternoMessageEnum {
    SERVICO_EXTERNO_AUTORIZACAO_INDISPONIVEL("O serviço de autorização está indisponível.", 500),
    SERVICO_EXTERNO_ENVIO_EMAIL_INDISPONIVEL("O serviço de envio de e-mail está indisponível.", 500);;

    private final String message;
    private final int statusCode;

    ServicoExternoMessageEnum(String message, int statusCode) {
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
