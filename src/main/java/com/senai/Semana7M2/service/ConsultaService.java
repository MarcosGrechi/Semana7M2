package com.senai.Semana7M2.service;

import com.senai.Semana7M2.dto.ConsultaRequestDTO;
import com.senai.Semana7M2.dto.ConsultaResponseDTO;
import com.senai.Semana7M2.model.Consulta;
import com.senai.Semana7M2.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public ConsultaResponseDTO criarConsulta(ConsultaRequestDTO requestDTO) {
        Consulta consulta = new Consulta();
        consulta.setObservacoes(requestDTO.getObservacoes());
        consulta.setDataConsulta(requestDTO.getDataConsulta());
        consultaRepository.save(consulta);

        return toResponseDTO(consulta);
    }

    public ConsultaResponseDTO atualizarConsulta(Long id, ConsultaRequestDTO requestDTO) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com ID: " + id));

        consulta.setObservacoes(requestDTO.getObservacoes());
        consulta.setDataConsulta(requestDTO.getDataConsulta());
        consultaRepository.save(consulta);

        return toResponseDTO(consulta);
    }

    public void deletarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    public ConsultaResponseDTO buscarConsultaPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com ID: " + id));

        return toResponseDTO(consulta);
    }

    public List<ConsultaResponseDTO> buscarTodasConsultas() {
        List<Consulta> consultas = consultaRepository.findAll();
        return consultas.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Métodos auxiliares
    private ConsultaResponseDTO toResponseDTO(Consulta consulta) {
        ConsultaResponseDTO responseDTO = new ConsultaResponseDTO();
        responseDTO.setId(consulta.getId());
        responseDTO.setObservacoes(consulta.getObservacoes());
        responseDTO.setDataConsulta(consulta.getDataConsulta());

        return responseDTO;
    }
}
