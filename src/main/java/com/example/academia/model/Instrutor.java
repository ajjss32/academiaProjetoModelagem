package com.example.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instrutor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instrutor_id")
    private long instrutorId;
    @Column(name = "inst_cpf",unique = true)
    private String instCpf;
    @Column(name = "inst_nome")
    private String instNome;
    @Column(name = "inst_endereco")
    private String instEndereco;
    @Column(name = "inst_telefone")
    private String instTelefone;
    @Column(name = "inst_celular")
    private String instCelular;
    @Column(name = "inst_email",unique = true)
    private String instEmail;
    @Column(name = "inst_formacao")
    private String instFormacao;

}
