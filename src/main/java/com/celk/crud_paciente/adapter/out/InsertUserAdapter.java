package com.celk.crud_paciente.adapter.out;

import com.celk.crud_paciente.adapter.out.repository.UserRepository;
import com.celk.crud_paciente.adapter.out.repository.mapper.UserRepositoryMapper;
import com.celk.crud_paciente.application.core.domain.User;
import com.celk.crud_paciente.application.ports.out.InsertUserOutput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InsertUserAdapter implements InsertUserOutput {

    private UserRepository userRepository;

    private UserRepositoryMapper mapper;

    @Override
    public void insert(User user) {
        userRepository.save(mapper.toEntity(user));
    }
}