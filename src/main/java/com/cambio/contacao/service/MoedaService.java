package com.cambio.contacao.service;

import com.cambio.contacao.model.Moeda;
import com.cambio.contacao.repository.MoedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoedaService {

    @Autowired
    private MoedaRepository moedaRepository;

    public List<Moeda> findAll() {
        return moedaRepository.findAll();
    }

    public Optional<Moeda> findById(Long id) {
        return moedaRepository.findById(id);
    }

    public Moeda save(Moeda moeda) {
        return moedaRepository.save(moeda);
    }

    public void deleteById(Long id) {
        moedaRepository.deleteById(id);
    }
}
