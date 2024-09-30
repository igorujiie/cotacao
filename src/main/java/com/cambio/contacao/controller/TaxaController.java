package com.cambio.contacao.controller;

import com.cambio.contacao.DTO.TaxaDTO;
import com.cambio.contacao.exception.MoedaNotFoundException;
import com.cambio.contacao.model.Moeda;
import com.cambio.contacao.model.Taxa;
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
        Moeda moeda = moedaService.findByCodigo(taxaDTO.getCodigoMoeda())
                .orElseThrow(() -> new MoedaNotFoundException("codigoMoeda nao existe ou nao foi encontrado"));
        Taxa taxa = new Taxa();
        taxa.setValorTaxaCompra(taxaDTO.getValorTaxaCompra());
        taxa.setValorTaxaVenda(taxaDTO.getValorTaxaVenda());
        taxa.setMoeda(moeda);
        Taxa savedTaxa = taxaService.save(taxaDTO);
        return ResponseEntity.ok(savedTaxa);
    }

    @DeleteMapping("/{id}")
    public void deleteTaxa(@PathVariable Long id) {
        taxaService.deleteById(id);
    }

    @ExceptionHandler(MoedaNotFoundException.class)
    public ResponseEntity<String> handleMoedaNotFoundException(MoedaNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}