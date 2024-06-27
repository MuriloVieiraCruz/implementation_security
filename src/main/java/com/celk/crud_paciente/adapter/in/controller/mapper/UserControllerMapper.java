package com.celk.crud_paciente.adapter.in.controller.mapper;

import com.celk.crud_paciente.adapter.in.controller.request.UserRequest;
import com.celk.crud_paciente.application.core.domain.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class UserControllerMapper {

    public User toDomain(UserRequest request) {
        return new User(
                null,
                request.username(),
                request.password(),
                new HashSet<>()
        );
    }

}
