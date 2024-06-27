package com.celk.crud_paciente.application.ports.out;

import com.celk.crud_paciente.application.core.domain.Paciente;

import java.util.UUID;

public interface UpdatePacienteOutput {

    void update(Paciente paciente);
}
