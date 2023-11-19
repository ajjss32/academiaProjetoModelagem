package com.example.academia.service;

import com.example.academia.model.Aluno;
import com.example.academia.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    public void buscarCpf(String cpf){
        alunoRepository.findByCpf(cpf).orElseThrow(()->new EntityNotFoundException("Aluno já cadastrado"));
    }

    public Aluno criarAluno(Aluno aluno){
        if (alunoRepository.findByCpf(aluno.getCpf()).isPresent()){
            throw new EntityNotFoundException("Aluno já cadastrado");
        }
        return alunoRepository.save(aluno);
    }
    public Aluno buscarAluno(String cpf){
        return alunoRepository.findByCpf(cpf).orElseThrow(()->new EntityNotFoundException("Aluno não encontrado"));
    }
    public Aluno editarAluno(String cpf){
        Aluno aluno = alunoRepository.findByCpf(cpf).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        Aluno alunoAtualizado = new Aluno();
        alunoAtualizado.setTelAluno(aluno.getTelAluno());
        alunoAtualizado.setCelAluno(aluno.getCelAluno());
        alunoAtualizado.setEndAluno(aluno.getEndAluno());
        return alunoRepository.save(alunoAtualizado);
    }
    public void deletarAluno(String cpf){
        Aluno aluno = alunoRepository.findByCpf(cpf).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        alunoRepository.delete(aluno);
    }
}
