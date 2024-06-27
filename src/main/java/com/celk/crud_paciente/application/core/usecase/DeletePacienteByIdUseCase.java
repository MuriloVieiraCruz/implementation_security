package com.celk.crud_paciente.application.core.usecase;

import com.celk.crud_paciente.application.ports.in.DeletePacienteByIdInput;
import com.celk.crud_paciente.application.ports.in.FindPacienteByIdInput;
import com.celk.crud_paciente.application.ports.out.DeletePacienteByIdOutput;
import com.celk.crud_paciente.application.ports.out.EnviarMensagemOutput;

import java.util.UUID;

public class DeletePacienteByIdUseCase implements DeletePacienteByIdInput {

    private final FindPacienteByIdInput findPacienteByIdInput;

    private final DeletePacienteByIdOutput deletePacienteByIdOutput;

    private final EnviarMensagemOutput enviarMensagemOutput;

    public DeletePacienteByIdUseCase(
            FindPacienteByIdInput findPacienteByIdInput,
            DeletePacienteByIdOutput deletePacienteByIdOutput,
            EnviarMensagemOutput enviarMensagemOutput
    ) {
        this.findPacienteByIdInput = findPacienteByIdInput;
        this.deletePacienteByIdOutput = deletePacienteByIdOutput;
        this.enviarMensagemOutput = enviarMensagemOutput;
    }

    @Override
    public void delete(UUID idPaciente) {
        findPacienteByIdInput.find(idPaciente);
        deletePacienteByIdOutput.delete(idPaciente);
    }
}
