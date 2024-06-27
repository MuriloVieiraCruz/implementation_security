package com.celk.crud_paciente.adapter.out.repository.mapper;

import com.celk.crud_paciente.adapter.out.repository.entity.PacienteEntity;
import com.celk.crud_paciente.application.core.domain.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteRepositoryMapper {

    public PacienteEntity toEntity(Paciente paciente) {
        return PacienteEntity.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .dataNascimento(paciente.getDataNascimento())
                .cpf(paciente.getCpf())
                .endereco(paciente.getEndereco())
                .telefone(paciente.getTelefone())
                .build();
    }

    public Paciente toDomain(PacienteEntity pacienteEntity) {
        return new Paciente(
                pacienteEntity.getId(),
                pacienteEntity.getNome(),
                pacienteEntity.getDataNascimento(),
                pacienteEntity.getCpf(),
                pacienteEntity.getEndereco(),
                pacienteEntity.getTelefone()
        );
    }
}
