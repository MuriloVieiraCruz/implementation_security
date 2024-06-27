package com.celk.crud_paciente.adapter.out;

import com.celk.crud_paciente.adapter.out.repository.PacienteRepository;
import com.celk.crud_paciente.adapter.out.repository.mapper.PacienteRepositoryMapper;
import com.celk.crud_paciente.application.core.domain.Paciente;
import com.celk.crud_paciente.application.ports.out.InsertPacienteOutput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InsertPacienteAdapter implements InsertPacienteOutput {

    private PacienteRepository pacienteRepository;
    private PacienteRepositoryMapper pacienteRepositoryMapper;

    @Override
    public void insert(Paciente paciente) {
        pacienteRepository.save(pacienteRepositoryMapper.toEntity(paciente));
    }
}
