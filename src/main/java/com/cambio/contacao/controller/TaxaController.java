package com.cambio.contacao.controller;

import com.cambio.contacao.DTO.TaxaDTO;
import com.cambio.contacao.model.Taxa;
import com.cambio.contacao.model.Moeda;
import com.cambio.contacao.service.TaxaService;
import com.cambio.contacao.service.MoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxas")
public class TaxaController {

    @Autowired
    private TaxaService taxaService;

    @Autowired
    private MoedaService moedaService;

    @GetMapping
    public List<TaxaDTO> getAllTaxas() {
        return taxaService.findAll();
    }

    @GetMapping("/{id}")
    public Taxa getTaxaById(@PathVariable Long id) {
        return taxaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Taxa> createTaxa(@RequestBody TaxaDTO taxaDTO) {
        try {
            Moeda moeda = moedaService.findByCodigo(taxaDTO.getCodigoMoeda())
                    .orElseThrow(() -> new IllegalArgumentException("Moeda não encontrada"));
            Taxa taxa = new Taxa();
            taxa.setValorTaxa(taxaDTO.getValorTaxa());
            taxa.setMoeda(moeda);
            Taxa savedTaxa = taxaService.save(taxaDTO);
            return ResponseEntity.ok(savedTaxa);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTaxa(@PathVariable Long id) {
        taxaService.deleteById(id);
    }
}