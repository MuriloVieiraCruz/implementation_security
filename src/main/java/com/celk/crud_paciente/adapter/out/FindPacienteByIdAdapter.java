package com.celk.crud_paciente.adapter.out;

import com.celk.crud_paciente.adapter.out.repository.PacienteRepository;
import com.celk.crud_paciente.adapter.out.repository.entity.PacienteEntity;
import com.celk.crud_paciente.adapter.out.repository.mapper.PacienteRepositoryMapper;
import com.celk.crud_paciente.application.core.domain.Paciente;
import com.celk.crud_paciente.application.ports.out.FindPacienteByIdOutput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
@Component
@AllArgsConstructor
public class FindPacienteByIdAdapter implements FindPacienteByIdOutput {

    private PacienteRepository pacienteRepository;

    private PacienteRepositoryMapper pacienteRepositoryMapper;

    @Override
    public Optional<Paciente> find(UUID idPaciente) {
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(idPaciente);
        return pacienteEntity.map(pacienteRepositoryMapper::toDomain);
    }
}
