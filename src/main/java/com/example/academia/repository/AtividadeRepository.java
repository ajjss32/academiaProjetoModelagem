package com.example.academia.repository;

import com.example.academia.model.Atividade;
import com.example.academia.model.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade,Long> {
    Optional<Atividade> findByNomeAtv(String nome);
}
