package com.celk.crud_paciente.adapter.out.repository;

import com.celk.crud_paciente.adapter.out.repository.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<PacienteEntity, UUID> {
}
