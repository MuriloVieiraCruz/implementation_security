package com.celk.crud_paciente.adapter.out;

import com.celk.crud_paciente.adapter.out.repository.PacienteRepository;
import com.celk.crud_paciente.adapter.out.repository.mapper.PacienteRepositoryMapper;
import com.celk.crud_paciente.application.core.domain.Paciente;
import com.celk.crud_paciente.application.ports.out.FindAllPacientesOutput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindAllPacientesAdapter implements FindAllPacientesOutput {

    private PacienteRepository pacienteRepository;

    private PacienteRepositoryMapper pacienteRepositoryMapper;

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll()
                .stream()
                .map(pacienteRepositoryMapper::toDomain)
                .toList();
    }
}
