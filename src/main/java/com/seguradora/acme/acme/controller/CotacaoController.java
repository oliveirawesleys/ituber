package com.seguradora.acme.acme.controller;

import com.seguradora.acme.acme.entity.CotacaoSeguro;
import com.seguradora.acme.acme.repository.CotacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    private CotacaoRepository cotacaoRepository;

    public CotacaoController(CotacaoRepository repository) {
        this.cotacaoRepository = repository;
    }

    @GetMapping("/todos")
    public List findAll() {
        return cotacaoRepository.findAll();
    }

    @GetMapping(path = {"/{idCotacao}"})
    public ResponseEntity findById(@PathVariable Long idCotacao){
        return cotacaoRepository.findById(idCotacao)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CotacaoSeguro create(@RequestBody CotacaoSeguro cotacao) {
        return cotacaoRepository.save(cotacao);
    }


    @GetMapping("/mensagem")
    public String getMensagem() {
        return "Chamando api.";
    }

}
