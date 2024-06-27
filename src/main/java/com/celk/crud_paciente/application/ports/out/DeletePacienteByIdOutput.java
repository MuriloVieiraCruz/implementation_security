package com.celk.crud_paciente.application.ports.out;

import java.util.UUID;

public interface DeletePacienteByIdOutput {

    void delete(UUID idPaciente);
}
