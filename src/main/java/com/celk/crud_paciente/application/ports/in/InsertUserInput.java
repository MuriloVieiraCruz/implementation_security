package com.celk.crud_paciente.application.ports.in;

import com.celk.crud_paciente.application.core.domain.User;

public interface InsertUserInput {

    void insert(User user);
}
