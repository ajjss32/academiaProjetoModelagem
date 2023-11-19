package com.example.academia.repository;

import com.example.academia.model.Aluno;
import com.example.academia.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Long> {
    @Query("SELECT m FROM Matricula m WHERE m.aluno = :aluno")
    Optional<Matricula> findByAluno(Aluno aluno);
}
