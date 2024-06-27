package com.celk.crud_paciente.application.ports.in;

import com.celk.crud_paciente.application.core.domain.Paciente;

import java.util.List;

public interface FindAllPacientesInput {

    List<Paciente> findAll();
}
