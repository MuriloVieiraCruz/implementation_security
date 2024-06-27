package com.celk.crud_paciente.application.core.domain;

public enum MensagemPacienteKafka {

    MENSAGEM_ENVIO_CRIACAO("Um paciente foi cadastrado"),
    MENSAGEM_ENVIO_ALTERACAO("Um paciente foi alterado"),
    MENSAGEM_ENVIO_EXCLUSAO("Um paciente foi deletado");

    private final String mensagem ;

    private MensagemPacienteKafka(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
