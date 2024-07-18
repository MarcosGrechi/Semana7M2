package com.senai.Semana7M2.controller;

import com.senai.Semana7M2.dto.NutricionistaRequestDTO;
import com.senai.Semana7M2.dto.NutricionistaResponseDTO;
import com.senai.Semana7M2.service.NutricionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutricionistas")
public class NutricionistaController {

    @Autowired
    private NutricionistaService nutricionistaService;

    @PostMapping
    public ResponseEntity<NutricionistaResponseDTO> criarNutricionista(@RequestBody NutricionistaRequestDTO requestDTO) {
        NutricionistaResponseDTO responseDTO = nutricionistaService.criarNutricionista(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NutricionistaResponseDTO> atualizarNutricionista(@PathVariable Long id, @RequestBody NutricionistaRequestDTO requestDTO) {
        NutricionistaResponseDTO responseDTO = nutricionistaService.atualizarNutricionista(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNutricionista(@PathVariable Long id) {
        nutricionistaService.deletarNutricionista(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutricionistaResponseDTO> buscarNutricionistaPorId(@PathVariable Long id) {
        NutricionistaResponseDTO responseDTO = nutricionistaService.buscarNutricionistaPorId(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<NutricionistaResponseDTO>> buscarTodosNutricionistas() {
        List<NutricionistaResponseDTO> responseDTOList = nutricionistaService.buscarTodosNutricionistas();
        return ResponseEntity.ok(responseDTOList);
    }
}
