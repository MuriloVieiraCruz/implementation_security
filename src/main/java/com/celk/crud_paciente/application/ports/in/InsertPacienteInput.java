package com.celk.crud_paciente.application.ports.in;

import com.celk.crud_paciente.application.core.domain.Paciente;

public interface InsertPacienteInput {

    void insert(Paciente paciente);
}
