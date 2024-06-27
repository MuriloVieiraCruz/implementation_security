package com.celk.crud_paciente.application.ports.in;

import com.celk.crud_paciente.application.core.domain.Paciente;

import java.util.UUID;

public interface FindPacienteByIdInput {

    Paciente find(UUID idPaciente);
}
