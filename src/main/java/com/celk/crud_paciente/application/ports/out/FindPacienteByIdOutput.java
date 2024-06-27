package com.celk.crud_paciente.application.ports.out;

import com.celk.crud_paciente.adapter.in.controller.response.PacienteResponse;
import com.celk.crud_paciente.application.core.domain.Paciente;

import java.util.Optional;
import java.util.UUID;

public interface FindPacienteByIdOutput {

    Optional<Paciente> find(UUID idPaciente);
}
