package com.example.academia.controller;

import com.example.academia.model.Aluno;
import com.example.academia.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/aluno")
@RestController
@CrossOrigin("*")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno){
        Aluno alunoCriado = alunoService.criarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCriado);
    }
    @GetMapping("/{cpf}")
    public ResponseEntity<Aluno> buscarAluno(@PathVariable(value = "cpf")String cpf){
        Aluno aluno = alunoService.buscarAluno(cpf);
        return ResponseEntity.ok(aluno);
    }
    @PutMapping("/{cpf}")
    public ResponseEntity<Aluno> editarAluno(@PathVariable(value = "cpf")String cpf){
        Aluno aluno = alunoService.editarAluno(cpf);
        return ResponseEntity.ok(aluno);
    }
    @DeleteMapping("/{cpf}")
    public ResponseEntity deletarAluno(@PathVariable(value = "cpf")String cpf){
        alunoService.deletarAluno(cpf);
        return ResponseEntity.ok("Aluno deletado com sucesso!");
    }

}
