package com.example.academia.service;

import com.example.academia.model.Instrutor;
import com.example.academia.repository.InstrutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrutorService {
    @Autowired
    private InstrutorRepository instrutorRepository;

    public Instrutor criarInstrutor(Instrutor instrutor){
        return instrutorRepository.save(instrutor);
    }
    public Instrutor buscarInstrutor(String cpf){
        Instrutor instrutor = instrutorRepository.findByInstCpf(cpf).orElseThrow(() -> new EntityNotFoundException("Instrutor já cadastrado"));
        return instrutor;
    }
    public Instrutor editarInstrutor(Instrutor instrutor){
        instrutorRepository.findByInstCpf(instrutor.getInstCpf()).orElseThrow(() -> new EntityNotFoundException("Instrutor não encontrado"));
        Instrutor instrutorAtualizado = new Instrutor();
        instrutorAtualizado.setInstCelular(instrutor.getInstCelular());
        instrutorAtualizado.setInstTelefone(instrutor.getInstTelefone());
        instrutorAtualizado.setInstEndereco(instrutor.getInstEndereco());
        return instrutorRepository.save(instrutorAtualizado);
    }
    public void deletarInstrutor(String cpf){
        Instrutor instrutor = instrutorRepository.findByInstCpf(cpf).orElseThrow(() -> new EntityNotFoundException("Instrutor não encontrado"));
        instrutorRepository.delete(instrutor);
    }
}
