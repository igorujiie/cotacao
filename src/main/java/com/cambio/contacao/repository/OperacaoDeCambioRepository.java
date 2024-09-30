package com.cambio.contacao.repository;

import com.cambio.contacao.DTO.CambioRequestDTO;
import com.cambio.contacao.model.OperacaoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoDeCambioRepository extends JpaRepository<OperacaoCambio, Long> {
}
