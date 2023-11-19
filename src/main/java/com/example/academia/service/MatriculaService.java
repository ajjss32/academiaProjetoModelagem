package com.example.academia.service;

import com.example.academia.model.Aluno;
import com.example.academia.model.Matricula;
import com.example.academia.model.Turma;
import com.example.academia.repository.MatriculaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private TurmaService turmaService;

    public Matricula buscaMatricula(String cpf){
        Aluno aluno = alunoService.buscarAluno(cpf);
        Optional<Matricula> matriculaOptional = matriculaRepository.findByAluno(aluno);
        return matriculaOptional.orElseThrow(()->new EntityNotFoundException("Nenhuma matriculá disponível"));
    }
    public Matricula atualizarMatricula(Long idMatricula,Long turmaId){
        Matricula matricula = matriculaRepository.findById(idMatricula).orElseThrow(()->new EntityNotFoundException("Nenhuma matriculá disponível"));
        Turma turma = turmaService.buscarTurma(turmaId);
        double valorAtividade = turma.getAtividade().getValorMensal();
        int numerParcelas = matricula.getNrParcelas();
        double valorTotal = matricula.getValorTotal();
        double novoValor = (valorAtividade*numerParcelas)+valorTotal;
        matricula.setValorTotal(novoValor);
        matricula.setValorMensal(novoValor/numerParcelas);
        adicionarTurma(turma,idMatricula);
        return matriculaRepository.save(matricula);

    }
    public Matricula criarMatricula(Matricula matricula,String cpf,Long turmaId){
        Aluno aluno = alunoService.buscarAluno(cpf);
        Turma turma = turmaService.buscarTurma(turmaId);
        double valorAtividade = turma.getAtividade().getValorMensal();
        int numerParcelas = matricula.getNrParcelas();
        matricula.setValorTotal(valorAtividade*numerParcelas);
        matricula.setValorMensal(valorAtividade);
        matricula.setAluno(aluno);
        Matricula saved = matriculaRepository.save(matricula);
        adicionarTurma(turma,saved.getMatriculaId());
        return saved;
    }

    public void adicionarTurma(Turma turma, Long idMatricula){
        Matricula matricula = matriculaRepository.findById(idMatricula).orElseThrow(() -> new EntityNotFoundException("Matricula não encontrada"));
        List<Turma> turmas = matricula.getTurmas();
        turmas.add(turma);
        matricula.setTurmas(turmas);
        matriculaRepository.save(matricula);

    }

}
