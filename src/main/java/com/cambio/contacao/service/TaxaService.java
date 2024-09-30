package com.cambio.contacao.service;

import com.cambio.contacao.DTO.TaxaDTO;
import com.cambio.contacao.model.Moeda;
import com.cambio.contacao.model.Taxa;
import com.cambio.contacao.repository.TaxaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxaService {

    @Autowired
    private TaxaRepository taxaRepository;

    @Autowired
    private MoedaService moedaService;

    public List<TaxaDTO> findAll() {
        return taxaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private TaxaDTO convertToDTO(Taxa taxa) {
        TaxaDTO taxaDTO = new TaxaDTO();
        taxaDTO.setValorTaxaCompra(taxa.getValorTaxaCompra());
        taxaDTO.setValorTaxaVenda(taxa.getValorTaxaVenda());
        taxaDTO.setCodigoMoeda(taxa.getMoeda().getCodigoMoeda());
        return taxaDTO;
    }

    public Taxa save(TaxaDTO taxaDTO) {
        Taxa taxa = new Taxa();
        taxa.setValorTaxaCompra(taxaDTO.getValorTaxaCompra());
        taxa.setValorTaxaVenda(taxaDTO.getValorTaxaVenda());
        Moeda moeda = moedaService.findByCodigo(taxaDTO.getCodigoMoeda())
                .orElseThrow(() -> new IllegalArgumentException("Moeda não encontrada"));
        taxa.setMoeda(moeda);
        return taxaRepository.save(taxa);
    }

    public void deleteById(Long id) {
        taxaRepository.deleteById(id);
    }

    public Taxa findById(Long id) {
        return taxaRepository.findById(id).orElse(null);
    }
}