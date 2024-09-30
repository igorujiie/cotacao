package com.cambio.contacao.service;

import com.cambio.contacao.DTO.CambioRequestDTO;
import com.cambio.contacao.enums.Operacao;
import com.cambio.contacao.model.OperacaoCambio;
import com.cambio.contacao.model.Moeda;
import com.cambio.contacao.model.Taxa;
import com.cambio.contacao.repository.OperacaoDeCambioRepository;
import com.cambio.contacao.util.Conversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CambioService {

    @Autowired
    private OperacaoDeCambioRepository operacaoDeCambioRepository;

    @Autowired
    private MoedaService moedaService;

    public OperacaoCambio save(CambioRequestDTO cambioRequestDTO) {
        Moeda moedaOrigem = moedaService.findByCodigo(cambioRequestDTO.getMoedaOrigem())
                .orElseThrow(() -> new IllegalArgumentException("Moeda de origem não encontrada"));
        Moeda moedaDestino = moedaService.findByCodigo(cambioRequestDTO.getMoedaDestino())
                .orElseThrow(() -> new IllegalArgumentException("Moeda de destino não encontrada"));

        Taxa taxaDestino = moedaDestino.getTaxa();
        Taxa taxaOrigem = moedaOrigem.getTaxa();
        if (taxaDestino == null) {
            throw new IllegalArgumentException("Taxa não encontrada para a moeda de destino");
        }

        BigDecimal valorConvertido;
        if (cambioRequestDTO.getOperacao().equals(Operacao.COMPRA)) {
            valorConvertido = Conversor.converterCompraDeMoeda(cambioRequestDTO.getValor(), taxaDestino.getValorTaxaCompra());
        } else {
            valorConvertido = Conversor.converterVendaDeMoeda(cambioRequestDTO.getValor(), taxaOrigem.getValorTaxaVenda());
        }

        OperacaoCambio operacaoCambio = new OperacaoCambio();
        operacaoCambio.setMoedaOrigem(moedaOrigem);
        operacaoCambio.setMoedaDestino(moedaDestino);
        operacaoCambio.setValor(cambioRequestDTO.getValor());
        operacaoCambio.setValorConvertido(valorConvertido);
        operacaoCambio.setOperacao(cambioRequestDTO.getOperacao());

        return operacaoDeCambioRepository.save(operacaoCambio);
    }

    public List<OperacaoCambio> findAll() {
        return operacaoDeCambioRepository.findAll();
    }

    public void deleteById(Long id) {
        operacaoDeCambioRepository.deleteById(id);
    }

    public OperacaoCambio findById(Long id) {
        return operacaoDeCambioRepository.findById(id).orElse(null);
    }
}