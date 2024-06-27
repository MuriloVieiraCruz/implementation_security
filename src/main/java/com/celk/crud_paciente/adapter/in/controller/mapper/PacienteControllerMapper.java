package com.celk.crud_paciente.adapter.in.controller.mapper;

import com.celk.crud_paciente.adapter.in.controller.request.PacienteRequest;
import com.celk.crud_paciente.adapter.in.controller.response.PacienteResponse;
import com.celk.crud_paciente.application.core.domain.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteControllerMapper {

    public Paciente toRequest(PacienteRequest pacienteRequest) {
        return new Paciente(
                null,
                pacienteRequest.nome(),
                pacienteRequest.dataNascimento(),
                pacienteRequest.cpf(),
                pacienteRequest.endereco(),
                pacienteRequest.telefone());

    }

    public PacienteResponse toResponse(Paciente paciente) {
        return new PacienteResponse(
                paciente.getId(),
                paciente.getNome(),
                paciente.getDataNascimento(),
                paciente.getCpf(),
                paciente.getEndereco(),
                paciente.getTelefone()
        );

    }

}
