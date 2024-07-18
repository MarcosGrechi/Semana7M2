package com.senai.Semana7M2.controller;

import com.senai.Semana7M2.dto.ConsultaRequestDTO;
import com.senai.Semana7M2.dto.ConsultaResponseDTO;
import com.senai.Semana7M2.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping("/criar")
    public ResponseEntity<ConsultaResponseDTO> criarConsulta(@RequestBody ConsultaRequestDTO requestDTO) {
        ConsultaResponseDTO consultaResponseDTO = consultaService.criarConsulta(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaResponseDTO);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ConsultaResponseDTO> atualizarConsulta(@PathVariable Long id, @RequestBody ConsultaRequestDTO requestDTO) {
        ConsultaResponseDTO consultaResponseDTO = consultaService.atualizarConsulta(id, requestDTO);
        return ResponseEntity.ok(consultaResponseDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> buscarConsultaPorId(@PathVariable Long id) {
        ConsultaResponseDTO consultaResponseDTO = consultaService.buscarConsultaPorId(id);
        return ResponseEntity.ok(consultaResponseDTO);
    }

    @GetMapping("/todas")
    public ResponseEntity<List<ConsultaResponseDTO>> buscarTodasConsultas() {
        List<ConsultaResponseDTO> consultas = consultaService.buscarTodasConsultas();
        return ResponseEntity.ok(consultas);
    }
}
