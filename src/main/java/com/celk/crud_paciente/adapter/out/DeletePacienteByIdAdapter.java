package com.celk.crud_paciente.adapter.out;

import com.celk.crud_paciente.adapter.out.repository.PacienteRepository;
import com.celk.crud_paciente.application.ports.out.DeletePacienteByIdOutput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class DeletePacienteByIdAdapter implements DeletePacienteByIdOutput {

    private PacienteRepository pacienteRepository;

    @Override
    public void delete(UUID idPaciente) {
        pacienteRepository.deleteById(idPaciente);
    }
}
