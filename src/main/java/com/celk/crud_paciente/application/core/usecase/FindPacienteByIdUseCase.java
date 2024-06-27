package com.celk.crud_paciente.application.core.usecase;

import com.celk.crud_paciente.adapter.in.controller.response.PacienteResponse;
import com.celk.crud_paciente.application.core.domain.Paciente;
import com.celk.crud_paciente.application.ports.in.FindPacienteByIdInput;
import com.celk.crud_paciente.application.ports.out.FindPacienteByIdOutput;

import java.util.UUID;

public class FindPacienteByIdUseCase implements FindPacienteByIdInput {

    private final FindPacienteByIdOutput findPacienteByIdOutput;

    public FindPacienteByIdUseCase(FindPacienteByIdOutput findPacienteByIdOutput) {
        this.findPacienteByIdOutput = findPacienteByIdOutput;
    }

    @Override
    public Paciente find(UUID idPaciente) {
        return findPacienteByIdOutput.find(idPaciente).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }
}
