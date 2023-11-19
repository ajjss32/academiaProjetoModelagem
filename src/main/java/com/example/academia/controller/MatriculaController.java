package com.example.academia.controller;

import com.example.academia.model.Matricula;
import com.example.academia.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/matricula")
@CrossOrigin("*")
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;
    @GetMapping("/{cpf}")
    public ResponseEntity<Matricula> buscaMatricula(@PathVariable(name = "cpf")String cpf){
        Matricula matricula = matriculaService.buscaMatricula(cpf);
        return ResponseEntity.ok(matricula);
    }

    @PostMapping("/{cpf}/{id}")
    public ResponseEntity<Matricula> criarMatricula(@PathVariable(name = "cpf")String cpf
            , @PathVariable(name = "id") Long id, @RequestBody Matricula matricula){
        Matricula matricula1 = matriculaService.criarMatricula(matricula, cpf, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(matricula1);
    }
    @PutMapping("/{idMatricula}/{idTurma}")
    public ResponseEntity<Matricula> atualizarMatricula(@PathVariable(name = "idMatricula")Long idMatricula
            , @PathVariable(name = "idTurma") Long idTurma){
        Matricula matricula = matriculaService.atualizarMatricula(idMatricula, idTurma);
        return ResponseEntity.ok(matricula);
    }


}
