package com.example.academia.controller;

import com.example.academia.model.Atividade;
import com.example.academia.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/atividade")
@RestController
@CrossOrigin("*")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping
    public ResponseEntity<Atividade>criarAtividade(@RequestBody Atividade atividade){
        Atividade atividade1 = atividadeService.criarAtividade(atividade);
        return ResponseEntity.status(HttpStatus.CREATED).body(atividade1);
    }
}
