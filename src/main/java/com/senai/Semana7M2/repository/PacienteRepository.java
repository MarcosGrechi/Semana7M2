package com.senai.Semana7M2.repository;

import com.senai.Semana7M2.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
