package com.senai.Semana7M2.service;

import com.senai.Semana7M2.dto.EnderecoResponseDTO;
import com.senai.Semana7M2.dto.PacienteRequestDTO;
import com.senai.Semana7M2.dto.PacienteResponseDTO;
import com.senai.Semana7M2.model.Endereco;
import com.senai.Semana7M2.model.Paciente;
import com.senai.Semana7M2.repository.EnderecoRepository;
import com.senai.Semana7M2.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public PacienteResponseDTO criarPaciente(PacienteRequestDTO pacienteRequestDTO) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteRequestDTO.getNome());
        paciente.setDataNascimento(pacienteRequestDTO.getDataNascimento());
        paciente.setCpf(pacienteRequestDTO.getCpf());
        paciente.setTelefone(pacienteRequestDTO.getTelefone());
        paciente.setEmail(pacienteRequestDTO.getEmail());

        Optional<Endereco> endereco = enderecoRepository.findById(pacienteRequestDTO.getEnderecoId());
        endereco.ifPresent(paciente::setEndereco);

        Paciente savedPaciente = pacienteRepository.save(paciente);
        return toResponseDTO(savedPaciente);
    }

    public PacienteResponseDTO atualizarPaciente(Long id, PacienteRequestDTO pacienteRequestDTO) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()) {
            Paciente paciente = optionalPaciente.get();
            paciente.setNome(pacienteRequestDTO.getNome());
            paciente.setDataNascimento(pacienteRequestDTO.getDataNascimento());
            paciente.setCpf(pacienteRequestDTO.getCpf());
            paciente.setTelefone(pacienteRequestDTO.getTelefone());
            paciente.setEmail(pacienteRequestDTO.getEmail());

            Optional<Endereco> endereco = enderecoRepository.findById(pacienteRequestDTO.getEnderecoId());
            endereco.ifPresent(paciente::setEndereco);

            Paciente updatedPaciente = pacienteRepository.save(paciente);
            return toResponseDTO(updatedPaciente);
        }
        throw new RuntimeException("Paciente não encontrado");
    }

    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public PacienteResponseDTO buscarPacientePorId(Long id) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()) {
            return toResponseDTO(optionalPaciente.get());
        }
        throw new RuntimeException("Paciente não encontrado");
    }

    public List<PacienteResponseDTO> buscarTodosPacientes() {
        return pacienteRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    private PacienteResponseDTO toResponseDTO(Paciente paciente) {
        PacienteResponseDTO responseDTO = new PacienteResponseDTO();
        responseDTO.setId(paciente.getId());
        responseDTO.setNome(paciente.getNome());
        responseDTO.setDataNascimento(paciente.getDataNascimento());
        responseDTO.setCpf(paciente.getCpf());
        responseDTO.setTelefone(paciente.getTelefone());
        responseDTO.setEmail(paciente.getEmail());

        Endereco endereco = paciente.getEndereco();
        if (endereco != null) {
            responseDTO.setEndereco(new EnderecoResponseDTO(
                    endereco.getId(), endereco.getLogradouro(), endereco.getEstado(), endereco.getCidade(),
                    endereco.getNumero(), endereco.getCep()
            ));
        }

        return responseDTO;
    }
}
