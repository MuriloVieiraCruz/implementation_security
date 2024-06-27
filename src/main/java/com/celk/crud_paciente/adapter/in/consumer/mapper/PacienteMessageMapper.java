package com.celk.crud_paciente.adapter.in.consumer.mapper;

import com.celk.crud_paciente.adapter.in.consumer.message.PacienteMessage;
import com.celk.crud_paciente.application.core.domain.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMessageMapper {

    public Paciente toDomain(PacienteMessage pacienteMessage) {
        return new Paciente(pacienteMessage.id(),
                pacienteMessage.nome(),
                pacienteMessage.dataNascimento(),
                pacienteMessage.cpf(),
                pacienteMessage.endereco(),
                pacienteMessage.telefone());
    }
}
