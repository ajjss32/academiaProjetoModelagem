package com.example.academia.repository;


import com.example.academia.model.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor,Long> {
    Optional<Instrutor> findByInstCpf(String cpf);
}
