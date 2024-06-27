package com.celk.crud_paciente.config;

import com.celk.crud_paciente.adapter.out.EnviarMensagemAdapter;
import com.celk.crud_paciente.adapter.out.InsertPacienteAdapter;
import com.celk.crud_paciente.application.core.usecase.InsertPatientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertPacienteConfig {

    @Bean
    public InsertPatientUseCase insertPatientUseCase
    (
            InsertPacienteAdapter insertPacienteAdapter,
            EnviarMensagemAdapter enviarMensagemAdapter
    ) {
        return new InsertPatientUseCase(insertPacienteAdapter, enviarMensagemAdapter);
    }
}
