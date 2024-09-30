package com.cambio.contacao.controller;

import com.cambio.contacao.DTO.CambioRequestDTO;
import com.cambio.contacao.model.OperacaoCambio;
import com.cambio.contacao.service.CambioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public OperacaoCambio getOperacaoCambioById(@PathVariable Long id, HttpServletRequest request) {
        return cambioService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOperacaoCambio(@Valid @RequestBody CambioRequestDTO cambioRequestDTO) {
        cambioRequestDTO.convertOperacaoToUpperCase();
        OperacaoCambio operacaoCambio = cambioService.save(cambioRequestDTO);

        Map<String, Object> response = new HashMap<>();
        response.put("valor", operacaoCambio.getValor());
        response.put("valorConvertido", operacaoCambio.getValorConvertido());
        response.put("operacao", operacaoCambio.getOperacao());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void deleteOperacaoCambio(@PathVariable Long id) {
        cambioService.deleteById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
}