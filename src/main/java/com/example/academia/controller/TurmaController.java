package com.example.academia.controller;


import com.example.academia.model.Turma;
import com.example.academia.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
@CrossOrigin("*")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @PostMapping("/{nomeAtividade}")
    public ResponseEntity<Turma> criarTurma(@RequestBody Turma turma,
                                            @PathVariable(name = "nomeAtividade") String nomeAtividade){
        Turma turmaCriada = turmaService.criarTurma(turma,nomeAtividade);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaCriada);
    }
    @GetMapping
    public ResponseEntity<List<Turma>> buscarTodasAsTurmas(){
        List<Turma> turmas = turmaService.buscarTodasTurmas();
        return ResponseEntity.ok(turmas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarTurma(@PathVariable(value = "id") Long id){
        Turma turma = turmaService.buscarTurma(id);
        return ResponseEntity.ok(turma);
    }

}
