package com.celk.crud_paciente.config;

import com.celk.crud_paciente.adapter.out.FindPacienteByIdAdapter;
import com.celk.crud_paciente.application.core.usecase.FindPacienteByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindPacienteByIdConfig {

    @Bean
    public FindPacienteByIdUseCase findPacienteByIdUseCase(FindPacienteByIdAdapter findPacienteByIdAdapter) {
        return new FindPacienteByIdUseCase(findPacienteByIdAdapter);
    }
}
