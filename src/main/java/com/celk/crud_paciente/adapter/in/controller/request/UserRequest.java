package com.celk.crud_paciente.adapter.in.controller.request;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(

        @NotBlank(message = "The name is required")
        String username,

        @NotBlank(message = "The password is required")
        String password
) {
}
