package com.example.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "turma")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turma_id")
    private Long turmaId;
    @OneToOne
    private Instrutor instrutor;
    @OneToOne
    private Aluno alunoMonitor;
    @ManyToOne
    private Atividade atividade;
    @Column(name = "capacidade_alunos")
    private int capacidadeAlunos;
    @Column(name = "horario_aula")
    private String horarioAula;
    @Column(name = "duracao_aula")
    private double duracaoAula;
    @Column(name = "data_inicial")
    private LocalDate dataInicial;
    @Column(name = "data_final")
    private LocalDate dataFinal;
    @Column(name = "turma_ativa")
    private boolean turmaAtiva =true;

}
