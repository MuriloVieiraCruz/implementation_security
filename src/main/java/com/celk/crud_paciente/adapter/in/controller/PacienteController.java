package com.celk.crud_paciente.adapter.in.controller;

import com.celk.crud_paciente.adapter.in.controller.mapper.PacienteControllerMapper;
import com.celk.crud_paciente.adapter.in.controller.request.PacienteRequest;
import com.celk.crud_paciente.adapter.in.controller.response.PacienteResponse;
import com.celk.crud_paciente.application.core.domain.Paciente;
import com.celk.crud_paciente.application.ports.in.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/paciente")
@AllArgsConstructor
public class PacienteController {

    private InsertPacienteInput insertPacienteInput;

    private FindPacienteByIdInput findPacienteByIdInput;

    private FindAllPacientesInput findAllPacientesInput;

    private UpdatePacienteInput updatePacienteInput;

    private DeletePacienteByIdInput deletePaciente;

    private PacienteControllerMapper pacienteControllerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid PacienteRequest pacienteRequest) {
        insertPacienteInput.insert(pacienteControllerMapper.toRequest(pacienteRequest));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> find(@PathVariable("id") UUID idPaciente) {
        PacienteResponse pacienteResponse = pacienteControllerMapper.toResponse(findPacienteByIdInput.find(idPaciente));
        return ResponseEntity.ok().body(pacienteResponse);
    }

    @GetMapping()
    public ResponseEntity<List<PacienteResponse>> findAll() {
        List<PacienteResponse> pacienteResponses = findAllPacientesInput.findAll()
                .stream()
                .map(pacienteControllerMapper::toResponse)
                .toList();

        return ResponseEntity.ok().body(pacienteResponses);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid PacienteRequest pacienteRequest, @PathVariable("id") UUID idPaciente) {
        Paciente paciente = pacienteControllerMapper.toRequest(pacienteRequest);
        paciente.setId(idPaciente);
        updatePacienteInput.update(paciente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID idPaciente) {
        deletePaciente.delete(idPaciente);
        return ResponseEntity.ok().build();
    }
}
