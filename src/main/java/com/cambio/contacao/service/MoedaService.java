package com.cambio.contacao.service;

import com.cambio.contacao.DTO.MoedaResponseDTO;
import com.cambio.contacao.model.Moeda;
import com.cambio.contacao.repository.MoedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MoedaService {

    @Autowired
    private MoedaRepository moedaRepository;

    public List<MoedaResponseDTO> findAll() {
        return moedaRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private MoedaResponseDTO convertToResponseDTO(Moeda moeda) {
        MoedaResponseDTO dto = new MoedaResponseDTO();
        dto.setId(moeda.getId());
        dto.setCodigoMoeda(moeda.getCodigoMoeda());
        dto.setNome(moeda.getNome());
        dto.setSimboloMoeda(moeda.getSimboloMoeda());
        dto.setTaxaCompra((moeda.getTaxa() != null) ? moeda.getTaxa().getValorTaxaCompra() : BigDecimal.ZERO);
        dto.setTaxaVenda((moeda.getTaxa() != null) ? moeda.getTaxa().getValorTaxaVenda() : BigDecimal.ZERO);
        return dto;
    }


    public Optional<Moeda> findById(Long id) {
        return moedaRepository.findById(id);
    }

    public Optional<Moeda> findByCodigo(String codigoMoeda) {
        return moedaRepository.findByCodigoMoeda(codigoMoeda);
    }

    public Moeda save(Moeda moeda) {
        if (moeda.getCodigoMoeda() == null || moeda.getCodigoMoeda().isEmpty()) {
            throw new IllegalArgumentException("CodigoMoeda nao pode ser nulo ou vazio");
        }
        return moedaRepository.save(moeda);

    }

    public void deleteById(Long id) {
        moedaRepository.deleteById(id);
    }
}
