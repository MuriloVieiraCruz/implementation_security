package com.celk.crud_paciente.application.core.usecase;

import com.celk.crud_paciente.application.core.domain.Paciente;
import com.celk.crud_paciente.application.ports.in.FindAllPacientesInput;
import com.celk.crud_paciente.application.ports.out.FindAllPacientesOutput;
import org.hibernate.ObjectNotFoundException;

import java.util.List;

public class FindAllPacientesUseCase implements FindAllPacientesInput {

    private final FindAllPacientesOutput findAllPacientesOutput;

    public FindAllPacientesUseCase(FindAllPacientesOutput findAllPacientesOutput) {
        this.findAllPacientesOutput = findAllPacientesOutput;
    }

    public List<Paciente> findAll() {

        List<Paciente> pacientes = findAllPacientesOutput.findAll();
        if (pacientes.isEmpty()) throw new ObjectNotFoundException("Nenhum paciente encontrado", Paciente.class);
        return pacientes;
    }
}
