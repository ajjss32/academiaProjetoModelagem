package com.example.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "matricula")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricula_id")
    private long matriculaId;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricula_nr")
    private UUID nrMatricula;
    @OneToOne
    private Aluno aluno;
    @Column(name = "data_mat")
    private LocalDate dataMat = LocalDate.now();
    @Column(name = "valor_total")
    private double valorTotal;
    @Column(name = "valor_mensal")
    private double valorMensal;
    @Column(name = "nr_parcelas")
    private int nrParcelas;
    @Column(name = "data_vencimento_pag")
    private int dataVencimentoPag;
    @Column(name = "status_matricula")
    private boolean statusMatricula;
    @OneToMany
    private List<Turma> turmas = new ArrayList<>();
}
