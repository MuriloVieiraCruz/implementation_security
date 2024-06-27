package com.celk.crud_paciente.application.ports.out;

import com.celk.crud_paciente.application.core.domain.User;

public interface InsertUserOutput {

    void insert(User user);
}
