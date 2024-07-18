package com.senai.Semana7M2.controller;

import com.senai.Semana7M2.dto.PacienteRequestDTO;
import com.senai.Semana7M2.dto.PacienteResponseDTO;
import com.senai.Semana7M2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> criarPaciente(@RequestBody PacienteRequestDTO requestDTO) {
        PacienteResponseDTO responseDTO = pacienteService.criarPaciente(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizarPaciente(@PathVariable Long id, @RequestBody PacienteRequestDTO requestDTO) {
        PacienteResponseDTO responseDTO = pacienteService.atualizarPaciente(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPacientePorId(@PathVariable Long id) {
        PacienteResponseDTO responseDTO = pacienteService.buscarPacientePorId(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> buscarTodosPacientes() {
        List<PacienteResponseDTO> responseDTOList = pacienteService.buscarTodosPacientes();
        return ResponseEntity.ok(responseDTOList);
    }
}
