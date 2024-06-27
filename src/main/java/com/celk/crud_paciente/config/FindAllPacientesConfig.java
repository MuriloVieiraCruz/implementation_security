package com.celk.crud_paciente.config;

import com.celk.crud_paciente.adapter.out.FindAllPacientesAdapter;
import com.celk.crud_paciente.application.core.usecase.FindAllPacientesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllPacientesConfig {

    @Bean
    public FindAllPacientesUseCase findAllPacientesUseCase
    (
            FindAllPacientesAdapter findAllPacientesAdapter
    ) {
        return new FindAllPacientesUseCase(findAllPacientesAdapter);
    }
}
