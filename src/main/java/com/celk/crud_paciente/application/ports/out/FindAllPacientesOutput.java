package com.celk.crud_paciente.application.ports.out;

import com.celk.crud_paciente.application.core.domain.Paciente;

import java.util.List;
import java.util.Optional;

public interface FindAllPacientesOutput {

    List<Paciente> findAll();
}
