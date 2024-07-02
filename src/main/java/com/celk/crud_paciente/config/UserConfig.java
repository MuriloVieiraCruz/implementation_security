package com.celk.crud_paciente.config;

import com.celk.crud_paciente.adapter.out.InsertUserAdapter;
import com.celk.crud_paciente.application.core.usecase.InsertUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public InsertUserUseCase insertUserUseCase(InsertUserAdapter insertUserAdapter) {
        return new InsertUserUseCase(insertUserAdapter);
    }
}
