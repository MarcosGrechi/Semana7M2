package com.senai.Semana7M2.controller;

import com.senai.Semana7M2.dto.EnderecoRequestDTO;
import com.senai.Semana7M2.dto.EnderecoResponseDTO;
import com.senai.Semana7M2.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> criarEndereco(@RequestBody EnderecoRequestDTO requestDTO) {
        EnderecoResponseDTO responseDTO = enderecoService.criarEndereco(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoRequestDTO requestDTO) {
        EnderecoResponseDTO responseDTO = enderecoService.atualizarEndereco(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> buscarEnderecoPorId(@PathVariable Long id) {
        EnderecoResponseDTO responseDTO = enderecoService.buscarEnderecoPorId(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> buscarTodosEnderecos() {
        List<EnderecoResponseDTO> responseDTOList = enderecoService.buscarTodosEnderecos();
        return ResponseEntity.ok(responseDTOList);
    }
}
