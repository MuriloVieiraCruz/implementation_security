package com.celk.crud_paciente.adapter.in.controller.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

public record PacienteResponse(
    UUID id,
    String nome,
    LocalDate dataNascimento,
    String cpf,
    String endereco,
    String telefone
) {
}
