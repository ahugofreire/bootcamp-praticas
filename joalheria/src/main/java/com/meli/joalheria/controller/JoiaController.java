package com.meli.joalheria.controller;

import com.meli.joalheria.entity.Joia;
import com.meli.joalheria.service.JoiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class JoiaController {

    @Autowired
    private JoiaService joiaService;

    @PostMapping("/joia/inserir")
    public ResponseEntity<Joia> inserir(@RequestBody Joia joia, UriComponentsBuilder uriBuilder) {
        Joia joiaCriada = joiaService.save(joia);

        URI uri = uriBuilder.path("/joias/{id}")
                .buildAndExpand(joiaCriada.getId())
                .toUri();

        return ResponseEntity.created(uri).body(joiaCriada);
    }

    @GetMapping("/joias")
    public ResponseEntity<List<Joia>> listar() {

        return ResponseEntity.ok().body(this.joiaService.find());
    }

    @GetMapping("/joias/{id}")
    public ResponseEntity<Joia> buscarUmPorId(@PathVariable Integer id) {
       return ResponseEntity.ok().body(this.joiaService.findOne(id));
    }

    @PutMapping("/joia/atualizar")
    public  ResponseEntity<Joia> atualizar(
            @RequestParam Integer id,
            @RequestBody Joia joia
    ) {

        Joia result = this.joiaService.update(joia, id);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/joia/excluir")
    public ResponseEntity<?> deletar(@RequestParam Integer id) {
        this.joiaService.delete(id);
        return ResponseEntity.noContent().build();
    }
 }
