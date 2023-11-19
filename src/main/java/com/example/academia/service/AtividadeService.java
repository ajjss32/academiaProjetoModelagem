package com.example.academia.service;

import com.example.academia.model.Atividade;
import com.example.academia.repository.AtividadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtividadeService {
    @Autowired
    private AtividadeRepository atividadeRepository;

    public Atividade criarAtividade(Atividade atividade){
        return atividadeRepository.save(atividade);
    }
    public Atividade buscarAtividade(String nome){
        return atividadeRepository.findByNomeAtv(nome).orElseThrow(() -> new EntityNotFoundException("Atividade não encontrada"));
    }
    public void deletarAtividade(long id){
        Atividade atividade = atividadeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Atividade não encontrada"));
        atividadeRepository.delete(atividade);
    }
}
