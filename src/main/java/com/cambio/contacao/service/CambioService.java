package com.cambio.contacao.service;

import com.cambio.contacao.model.OperacaoCambio;
import com.cambio.contacao.model.Moeda;
import com.cambio.contacao.repository.OperacaoDeCambioRepository;
import com.cambio.contacao.repository.MoedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CambioService {

    @Autowired
    private OperacaoDeCambioRepository operacaoDeCambioRepository;

    @Autowired
    private MoedaRepository moedaRepository;

    public List<OperacaoCambio> findAll() {
        return operacaoDeCambioRepository.findAll();
    }

    public OperacaoCambio save(OperacaoCambio operacaoCambio) {
        Moeda moedaOrigem = moedaRepository.findById(operacaoCambio.getMoedaOrigem().getId())
                .orElseThrow(() -> new IllegalArgumentException("Moeda de origem não encontrada"));
        Moeda moedaDestino = moedaRepository.findById(operacaoCambio.getMoedaDestino().getId())
                .orElseThrow(() -> new IllegalArgumentException("Moeda de destino não encontrada"));

        operacaoCambio.setMoedaOrigem(moedaOrigem);
        operacaoCambio.setMoedaDestino(moedaDestino);
        operacaoCambio.calcularValorConvertido();

        return operacaoDeCambioRepository.save(operacaoCambio);
    }

    public void deleteById(Long id) {
        operacaoDeCambioRepository.deleteById(id);
    }

    public OperacaoCambio findById(Long id) {
        return operacaoDeCambioRepository.findById(id).orElse(null);
    }
}