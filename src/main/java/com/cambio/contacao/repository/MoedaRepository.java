package com.cambio.contacao.repository;

import com.cambio.contacao.model.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoedaRepository extends JpaRepository<Moeda, Long> {
    Optional<Moeda> findByCodigoMoeda(String codigoMoeda);
}