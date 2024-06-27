package com.celk.crud_paciente.config;

import com.celk.crud_paciente.adapter.out.EnviarMensagemAdapter;
import com.celk.crud_paciente.adapter.out.UpdatePacienteAdapter;
import com.celk.crud_paciente.application.core.usecase.FindPacienteByIdUseCase;
import com.celk.crud_paciente.application.core.usecase.UpdatePacienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdatePacienteConfig {

    @Bean
    public UpdatePacienteUseCase updatePacienteUseCase
    (
            FindPacienteByIdUseCase findPacienteByIdUseCase,
            UpdatePacienteAdapter updatePacienteAdapter,
            EnviarMensagemAdapter enviarMensagemAdapter
    ) {
        return new UpdatePacienteUseCase(findPacienteByIdUseCase, updatePacienteAdapter, enviarMensagemAdapter);
    }
}
