package com.example.academia.controller;

import com.example.academia.model.Instrutor;
import com.example.academia.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/instrutor")
@RestController
@CrossOrigin("*")
public class InstrutorController {
    @Autowired
    private InstrutorService instrutorService;
    @PostMapping
    public ResponseEntity<Instrutor> criarInstrutor(@RequestBody Instrutor instrutor){
        Instrutor instrutor1 = instrutorService.criarInstrutor(instrutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(instrutor1);
    }

}
