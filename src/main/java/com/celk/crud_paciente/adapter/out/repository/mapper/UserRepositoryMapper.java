package com.celk.crud_paciente.adapter.out.repository.mapper;

import com.celk.crud_paciente.adapter.out.repository.entity.UserEntity;
import com.celk.crud_paciente.application.core.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryMapper {

    public UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }

    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getRoles());
    }
}
