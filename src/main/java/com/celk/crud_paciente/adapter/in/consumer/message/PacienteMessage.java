package com.celk.crud_paciente.adapter.in.consumer.message;

import java.time.LocalDate;
import java.util.UUID;

public record PacienteMessage(
        UUID id,
        String nome,
        LocalDate dataNascimento,
        String cpf,
        String endereco,
        String telefone
) {

}
