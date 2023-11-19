package com.example.academia.service;

import com.example.academia.model.*;
import com.example.academia.repository.TurmaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private AtividadeService atividadeService;

    public Turma criarTurma(Turma turma,String atividade){
        Atividade atividade1 = atividadeService.buscarAtividade(atividade);
        turma.setAtividade(atividade1);
        return turmaRepository.save(turma);
    }
    public List<Turma> buscarTodasTurmas(){
        return turmaRepository.findAll();
    }
    public Turma buscarTurma(Long id){
        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));
        return turma;
    }
    public void inativarTurma(Long id){
        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));
        turma.setTurmaAtiva(false);
    }
    public void vincularAlunoMonitor(Long id, Matricula matricula){
        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));
        turma.setAlunoMonitor(matricula.getAluno());
    }
    public void vincularInstrutor(Long id, Instrutor instrutor){
        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));
        turma.setInstrutor(instrutor);
    }
    public void verificarTurmaIncompleta(Long id){
        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));
        if (turma.getAlunoMonitor()==null || turma.getInstrutor()==null){
            throw new RuntimeException("Turma incompleta");
        }
    }


}
