package com.senai.Semana7M2.service;

import com.senai.Semana7M2.dto.EnderecoRequestDTO;
import com.senai.Semana7M2.dto.EnderecoResponseDTO;
import com.senai.Semana7M2.model.Endereco;
import com.senai.Semana7M2.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoResponseDTO criarEndereco(EnderecoRequestDTO enderecoRequestDTO) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoRequestDTO.getLogradouro());
        endereco.setEstado(enderecoRequestDTO.getEstado());
        endereco.setCidade(enderecoRequestDTO.getCidade());
        endereco.setNumero(enderecoRequestDTO.getNumero());
        endereco.setCep(enderecoRequestDTO.getCep());

        Endereco savedEndereco = enderecoRepository.save(endereco);
        return toResponseDTO(savedEndereco);
    }

    public EnderecoResponseDTO atualizarEndereco(Long id, EnderecoRequestDTO enderecoRequestDTO) {
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);
        if (optionalEndereco.isPresent()) {
            Endereco endereco = optionalEndereco.get();
            endereco.setLogradouro(enderecoRequestDTO.getLogradouro());
            endereco.setEstado(enderecoRequestDTO.getEstado());
            endereco.setCidade(enderecoRequestDTO.getCidade());
            endereco.setNumero(enderecoRequestDTO.getNumero());
            endereco.setCep(enderecoRequestDTO.getCep());

            Endereco updatedEndereco = enderecoRepository.save(endereco);
            return toResponseDTO(updatedEndereco);
        }
        throw new RuntimeException("Endereço não encontrado");
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }

    public EnderecoResponseDTO buscarEnderecoPorId(Long id) {
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);
        if (optionalEndereco.isPresent()) {
            return toResponseDTO(optionalEndereco.get());
        }
        throw new RuntimeException("Endereço não encontrado");
    }

    public List<EnderecoResponseDTO> buscarTodosEnderecos() {
        return enderecoRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    private EnderecoResponseDTO toResponseDTO(Endereco endereco) {
        return new EnderecoResponseDTO(
                endereco.getId(),
                endereco.getLogradouro(),
                endereco.getEstado(),
                endereco.getCidade(),
                endereco.getNumero(),
                endereco.getCep()
        );
    }
}
