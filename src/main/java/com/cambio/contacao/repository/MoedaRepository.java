package com.cambio.contacao.repository;

import com.cambio.contacao.model.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoedaRepository extends JpaRepository<Moeda, Long> {
}
