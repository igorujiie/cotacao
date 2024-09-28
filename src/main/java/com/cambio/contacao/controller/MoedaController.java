package com.cambio.contacao.controller;

import com.cambio.contacao.model.Moeda;
import com.cambio.contacao.service.MoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moedas")
public class MoedaController {

    @Autowired
    private MoedaService moedaService;

    @GetMapping
    public List<Moeda> getAllMoedas() {
        return moedaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moeda> getMoedaById(@PathVariable Long id) {
        Optional<Moeda> moeda = moedaService.findById(id);
        return moeda.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Moeda createMoeda(@RequestBody Moeda moeda) {
        return moedaService.save(moeda);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMoeda(@PathVariable Long id) {
        if (moedaService.findById(id).isPresent()) {
            moedaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
