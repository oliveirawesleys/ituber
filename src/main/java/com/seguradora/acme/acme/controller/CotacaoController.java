package com.seguradora.acme.acme.controller;

import com.seguradora.acme.acme.repository.CotacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    private CotacaoRepository cotacaoRepository;

    public CotacaoController(CotacaoRepository repository) {
        this.cotacaoRepository = repository;
    }

    @GetMapping
    public List findAll() {
        return cotacaoRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return cotacaoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}
