package com.cambio.contacao.service;

import com.cambio.contacao.model.OperacaoCambio;
import com.cambio.contacao.repository.OperacaoDeCambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CambioService {

    @Autowired
    private OperacaoDeCambioRepository operacaoDeCambioRepository;


    public List<OperacaoCambio> findAll() {
        return operacaoDeCambioRepository.findAll();
    }

    public OperacaoCambio save(OperacaoCambio operacaoCambio) {
        return operacaoDeCambioRepository.save(operacaoCambio);
    }

    public void deleteById(Long id) {
        operacaoDeCambioRepository.deleteById(id);
    }

    public OperacaoCambio findById(Long id) {
        return operacaoDeCambioRepository.findById(id).orElse(null);
    }

}
