package com.senai.Semana7M2.service;

import com.senai.Semana7M2.dto.NutricionistaRequestDTO;
import com.senai.Semana7M2.dto.NutricionistaResponseDTO;
import com.senai.Semana7M2.model.Nutricionista;
import com.senai.Semana7M2.repository.NutricionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NutricionistaService {

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    public NutricionistaResponseDTO criarNutricionista(NutricionistaRequestDTO requestDTO) {
        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setNome(requestDTO.getNome());
        nutricionista.setTempoExperiencia(requestDTO.getTempoExperiencia());
        nutricionistaRepository.save(nutricionista);  // Pode ser necessário verificar o retorno de save

        return new NutricionistaResponseDTO(nutricionista.getId(), nutricionista.getNome(), nutricionista.getTempoExperiencia());
    }

    public NutricionistaResponseDTO atualizarNutricionista(Long id, NutricionistaRequestDTO requestDTO) {
        Nutricionista nutricionista = nutricionistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nutricionista não encontrado com ID: " + id));

        nutricionista.setNome(requestDTO.getNome());
        nutricionista.setTempoExperiencia(requestDTO.getTempoExperiencia());
        nutricionistaRepository.save(nutricionista);  // Pode ser necessário verificar o retorno de save

        return new NutricionistaResponseDTO(nutricionista.getId(), nutricionista.getNome(), nutricionista.getTempoExperiencia());
    }

    public void deletarNutricionista(Long id) {
        nutricionistaRepository.deleteById(id);
    }

    public NutricionistaResponseDTO buscarNutricionistaPorId(Long id) {
        Nutricionista nutricionista = nutricionistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nutricionista não encontrado com ID: " + id));

        return new NutricionistaResponseDTO(nutricionista.getId(), nutricionista.getNome(), nutricionista.getTempoExperiencia());
    }

    public List<NutricionistaResponseDTO> buscarTodosNutricionistas() {
        List<Nutricionista> nutricionistas = nutricionistaRepository.findAll();
        return nutricionistas.stream()
                .map(nutricionista -> new NutricionistaResponseDTO(nutricionista.getId(), nutricionista.getNome(), nutricionista.getTempoExperiencia()))
                .collect(Collectors.toList());
    }
}
