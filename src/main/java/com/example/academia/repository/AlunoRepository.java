package com.example.academia.repository;

import com.example.academia.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    Optional<Aluno> findByCpf(String cpf);
}
