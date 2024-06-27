package com.celk.crud_paciente.application.core.usecase;

import com.celk.crud_paciente.application.core.domain.MensagemPacienteKafka;
import com.celk.crud_paciente.application.core.domain.Paciente;
import com.celk.crud_paciente.application.ports.in.FindPacienteByIdInput;
import com.celk.crud_paciente.application.ports.in.UpdatePacienteInput;
import com.celk.crud_paciente.application.ports.out.EnviarMensagemOutput;
import com.celk.crud_paciente.application.ports.out.UpdatePacienteOutput;

public class UpdatePacienteUseCase implements UpdatePacienteInput {

    private final FindPacienteByIdInput findPacienteByIdInput;

    private final UpdatePacienteOutput updatePacienteOutput;

    private final EnviarMensagemOutput enviarMensagemOutput;

    public UpdatePacienteUseCase(
            FindPacienteByIdInput findPacienteByIdInput,
            UpdatePacienteOutput updatePacienteOutput,
            EnviarMensagemOutput enviarMensagemOutput
    ) {
        this.findPacienteByIdInput = findPacienteByIdInput;
        this.updatePacienteOutput = updatePacienteOutput;
        this.enviarMensagemOutput = enviarMensagemOutput;
    }

    @Override
    public void update(Paciente paciente) {
        findPacienteByIdInput.find(paciente.getId());

        updatePacienteOutput.update(paciente);
        enviarMensagemOutput.send(MensagemPacienteKafka.MENSAGEM_ENVIO_ALTERACAO.getMensagem());
    }
}
