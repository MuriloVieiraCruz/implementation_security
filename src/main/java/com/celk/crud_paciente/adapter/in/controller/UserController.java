package com.celk.crud_paciente.adapter.in.controller;

import com.celk.crud_paciente.adapter.in.controller.mapper.UserControllerMapper;
import com.celk.crud_paciente.adapter.in.controller.request.UserRequest;
import com.celk.crud_paciente.application.ports.in.InsertUserInput;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private InsertUserInput insertUserInput;

    private UserControllerMapper mapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserRequest request) {
        insertUserInput.insert(mapper.toDomain(request));
        return ResponseEntity.ok().build();
    }
}
