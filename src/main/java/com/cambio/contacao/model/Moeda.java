package com.cambio.contacao.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Moeda {
    private String codigo;
    private String nomeMoeda;
    private BigDecimal taxaBase;
    private BigDecimal taxaCompra;
    private BigDecimal taxaVenda;
}
