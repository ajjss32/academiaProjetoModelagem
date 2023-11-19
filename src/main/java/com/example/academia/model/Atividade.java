package com.example.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "atividade")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atividade_id")
    private Long atividadeId;
    @Column(name = "nome_atv",unique = true)
    private String nomeAtv;
    @Column(name = "descricao_atv")
    private String descricaoAtv;
    @Column(name = "valor_mensal")
    private double valorMensal;
}
