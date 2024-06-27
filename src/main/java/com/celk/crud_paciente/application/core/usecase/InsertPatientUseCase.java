package com.celk.crud_paciente.application.core.usecase;

import com.celk.crud_paciente.application.core.domain.MensagemPacienteKafka;
import com.celk.crud_paciente.application.core.domain.Paciente;
import com.celk.crud_paciente.application.ports.in.InsertPacienteInput;
import com.celk.crud_paciente.application.ports.out.EnviarMensagemOutput;
import com.celk.crud_paciente.application.ports.out.InsertPacienteOutput;

public class InsertPatientUseCase implements InsertPacienteInput {

    private final InsertPacienteOutput insertPacienteOutput;
    private final EnviarMensagemOutput enviarMensagemOutput;

    public InsertPatientUseCase(InsertPacienteOutput insertPacienteOutput, EnviarMensagemOutput enviarMensagemOutput) {
        this.insertPacienteOutput = insertPacienteOutput;
        this.enviarMensagemOutput = enviarMensagemOutput;
    }

    @Override
    public void insert(Paciente paciente) {
        insertPacienteOutput.insert(paciente);
        enviarMensagemOutput.send(MensagemPacienteKafka.MENSAGEM_ENVIO_CRIACAO.getMensagem());
    }
}
