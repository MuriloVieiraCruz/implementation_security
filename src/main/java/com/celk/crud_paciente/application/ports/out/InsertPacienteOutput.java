package com.celk.crud_paciente.application.ports.out;

import com.celk.crud_paciente.application.core.domain.Paciente;

public interface InsertPacienteOutput {

    void insert(Paciente paciente);
}
