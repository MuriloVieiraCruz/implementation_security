package com.celk.crud_paciente.adapter.in.consumer;

import com.celk.crud_paciente.adapter.in.consumer.mapper.PacienteMessageMapper;
import com.celk.crud_paciente.adapter.in.consumer.message.PacienteMessage;
import com.celk.crud_paciente.application.ports.in.UpdatePacienteInput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReceiveValidatedTelefone {

    private UpdatePacienteInput updatePacienteInput;

    private PacienteMessageMapper pacienteMessageMapper;

    //@KafkaListener(topics = "tp-paciente-formatado", groupId = "celk")
    public void receive(PacienteMessage message) {
        updatePacienteInput.update(pacienteMessageMapper.toDomain(message));
    }
}
