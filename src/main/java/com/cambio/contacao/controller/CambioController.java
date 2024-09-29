package com.cambio.contacao.controller;


import com.cambio.contacao.model.OperacaoCambio;
import com.cambio.contacao.service.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cambio")
public class CambioController {

    @Autowired
    private CambioService cambioService;

    @GetMapping
    public List<OperacaoCambio> getAllOperacoesCambio() {
        return cambioService.findAll();
    }

    @GetMapping("/{id}")
    public OperacaoCambio getOperacaoCambioById(Long id) {
        return cambioService.findById(id);
    }

    @PostMapping
    public OperacaoCambio createOperacaoCambio(OperacaoCambio operacaoCambio) {
        return cambioService.save(operacaoCambio);
    }

    @DeleteMapping("/{id}")
    public void deleteOperacaoCambio(Long id) {
        cambioService.deleteById(id);
    }


}
