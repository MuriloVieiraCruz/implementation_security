package com.celk.crud_paciente.application.core.usecase;

import com.celk.crud_paciente.application.core.domain.User;
import com.celk.crud_paciente.application.ports.in.InsertUserInput;
import com.celk.crud_paciente.application.ports.out.InsertPacienteOutput;
import com.celk.crud_paciente.application.ports.out.InsertUserOutput;

public class InsertUserUseCase implements InsertUserInput {

    private final InsertUserOutput insertUserOutput;

    public InsertUserUseCase(InsertUserOutput insertUserOutput) {
        this.insertUserOutput = insertUserOutput;
    }

    @Override
    public void insert(User user) {
        insertUserOutput.insert(user);
    }
}
