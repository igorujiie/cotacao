package com.cambio.contacao.controller;

import com.cambio.contacao.DTO.CambioRequestDTO;
import com.cambio.contacao.model.Moeda;
import com.cambio.contacao.model.OperacaoCambio;
import com.cambio.contacao.service.CambioService;
import com.cambio.contacao.service.MoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cambio")
public class CambioController {


    @Autowired
    private CambioService cambioService;

    @Autowired
    private MoedaService moedaService;

    @GetMapping
    public List<OperacaoCambio> getAllOperacoesCambio() {
        return cambioService.findAll();
    }

    @GetMapping("/{id}")
    public OperacaoCambio getOperacaoCambioById(@PathVariable Long id) {
        return cambioService.findById(id);
    }



    @PostMapping
    public ResponseEntity<OperacaoCambio> createOperacaoCambio(@RequestBody CambioRequestDTO cambioRequestDTO) {
        OperacaoCambio operacaoCambio = cambioService.save(cambioRequestDTO);
        return ResponseEntity.ok(operacaoCambio);
    }

    @DeleteMapping("/{id}")
    public void deleteOperacaoCambio(@PathVariable Long id) {
        cambioService.deleteById(id);
    }
}