package com.example.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id")
    private Long alunoId;
    @Column(unique = true)
    private String cpf;
    @Column(name = "nome_aluno")
    private String nomeAluno;
    @Column(name = "tel_aluno")
    private String telAluno;
    @Column(name = "cel_aluno")
    private String celAluno;
    @Column(name = "end_aluno")
    private String endAluno;
    @Column(unique = true)
    private String emailAluno;

}
