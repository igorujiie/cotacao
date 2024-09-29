package com.cambio.contacao.repository;

import com.cambio.contacao.model.OperacaoCambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacaoDeCambioRepository extends JpaRepository<OperacaoCambio, Long> {
}
