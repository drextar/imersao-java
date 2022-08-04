/*
 * ******************************************************************************************
 * Copyright©
 *
 * Este software foi desenvolvido por Vinicius Chiarotti seguindo a Imersão Java da Alura.
 *
 * Criado em: 03/08/2022
 * Autor: Vinicius Chiarotti
 * Contato: vchiarotti@outlook.com
 *
 * ------------------------------------------------------------------------------------------
 * Portfolio: https://drextar.github.io/Portfolio/
 * Github: https://github.com/drextar
 * ------------------------------------------------------------------------------------------
 * ******************************************************************************************
 */
package br.com.drextar.linguagens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/linguagens")
public class LinguagemController implements Comparable<Linguagem> {
    @Autowired
    private LinguagemRepository repository;

    @GetMapping
    public List<Linguagem> obterLinguaguens(){
        List<Linguagem> linguagens = repository.findAll();
        linguagens.sort(Comparator.comparing(Linguagem::getVotes).reversed());
        return linguagens;
    }

    @PatchMapping("/{id}")
    public Linguagem atualizarLinguagem(@PathVariable String id, @RequestBody Linguagem linguagem){
        Linguagem linguagemAtual = repository.findById(id).get();
        System.out.println(linguagem);
        int votes = linguagemAtual.getVotes() + 1;
        linguagemAtual.setVotes(votes);
        return repository.save(linguagemAtual);
    }

    @PostMapping
    public ResponseEntity<Linguagem> cadastrarLinguagem(@RequestBody Linguagem linguagem){
        repository.save(linguagem);
        return new ResponseEntity<Linguagem>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public Linguagem deletarLinguagem(@RequestBody Linguagem linguagem){
        repository.delete(linguagem);
        return linguagem;
    }

    @Override
    public int compareTo(Linguagem o){
        return 0;
    }
}

