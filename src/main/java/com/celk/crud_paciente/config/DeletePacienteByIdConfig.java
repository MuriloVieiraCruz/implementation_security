package com.celk.crud_paciente.config;

import com.celk.crud_paciente.adapter.out.DeletePacienteByIdAdapter;
import com.celk.crud_paciente.adapter.out.EnviarMensagemAdapter;
import com.celk.crud_paciente.application.core.usecase.DeletePacienteByIdUseCase;
import com.celk.crud_paciente.application.core.usecase.FindPacienteByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletePacienteByIdConfig {

    @Bean
    public DeletePacienteByIdUseCase deletePacienteByIdUseCase
    (
            FindPacienteByIdUseCase findPacienteByIdUseCase,
            DeletePacienteByIdAdapter deletePacienteByIdAdapter,
            EnviarMensagemAdapter enviarMensagemAdapter
    ) {
        return new DeletePacienteByIdUseCase(findPacienteByIdUseCase, deletePacienteByIdAdapter, enviarMensagemAdapter);
    }
}
