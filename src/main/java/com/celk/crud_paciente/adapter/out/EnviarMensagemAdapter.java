package com.celk.crud_paciente.adapter.out;

import com.celk.crud_paciente.application.ports.out.EnviarMensagemOutput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnviarMensagemAdapter implements EnviarMensagemOutput {

    //private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String mensagem) {
        //kafkaTemplate.send("tp-send-message", mensagem);
    }
}
