package com.senai.Semana7M2.repository;

import com.senai.Semana7M2.model.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {
    boolean existsByNome(String nome);
}
