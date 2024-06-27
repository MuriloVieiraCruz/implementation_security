package com.celk.crud_paciente.application.ports.in;

import java.util.UUID;

public interface DeletePacienteByIdInput {

    void delete(UUID idPaciente);
}
