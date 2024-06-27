package com.celk.crud_paciente.adapter.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record PacienteRequest(

    @NotBlank(message = "Nome não pode ser vazio")
    String nome,

    @NotNull(message = "A data de nascimento deve ser informada")
    LocalDate dataNascimento,

    @CPF(message = "CPF inválido")
    @NotNull(message = "O CPF deve ser informado")
    String cpf,

    @NotBlank(message = "Endereço não pode ser vazio")
    String endereco,

    @NotBlank(message = "Telefone não pode ser vazio")
    String telefone
) {
}
