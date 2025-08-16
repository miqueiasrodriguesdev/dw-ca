package com.miqueias_r.core.exception.enums.message;

public enum UsuarioMessageEnum {
    USUARIO_NAO_ENCONTRADO("Não encontramos o usuário informado.", 404),
    USUARIO_EM_USO("O usuário já está cadastrado.", 400),

    USUARIO_CPF_CNPJ_INVALIDO("O número informado não é um CPF ou CNPJ válido.", 400),
    USUARIO_CPF_INVALIDO("O CPF informado é inválido. Por favor, verifique e tente novamente.", 400),
    USUARIO_CNPJ_INVALIDO("O CNPJ informado é inválido. Por favor, verifique e tente novamente.", 400),

    USUARIO_EMAIL_INVALIDO("O e-mail informado é inválido. Por favor, informe um endereço de e-mail válido.", 400),
    USUARIO_EMAIL_EM_USO("O e-mail já está cadastrado.", 400),

    USUARIO_CPF_CNPJ_NULO("O CPF ou CNPJ é obrigatório e não pode estar vazio.", 400),
    USUARIO_NOME_COMPLETO_NULO("O nome completo é obrigatório e não pode estar vazio.", 400),
    USUARIO_EMAIL_NULO("O e-mail é obrigatório e não pode estar vazio.", 400),
    USUARIO_SENHA_NULA("A senha é obrigatória e não pode estar vazia.", 400),
    USUARIO_TIPO_NULO("O tipo do usuário é obrigatório e não pode estar vazio.", 400),

    USUARIO_TIPO_NAO_EXISTE("O tipo do usuário não existe.", 400);

    private final String message;
    private final int statusCode;

    UsuarioMessageEnum(String message, int statusCode) {
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
