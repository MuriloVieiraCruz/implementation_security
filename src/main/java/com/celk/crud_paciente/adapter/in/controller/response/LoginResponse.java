package com.celk.crud_paciente.adapter.in.controller.response;

public record LoginResponse(
        String accessToken,
        Long expiresIn
) {
}
