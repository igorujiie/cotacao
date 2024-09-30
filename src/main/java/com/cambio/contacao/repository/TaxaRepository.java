package com.cambio.contacao.repository;

import com.cambio.contacao.model.Taxa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxaRepository extends JpaRepository<Taxa, Long> {
}
