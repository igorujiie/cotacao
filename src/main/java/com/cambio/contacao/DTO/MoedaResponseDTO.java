package com.cambio.contacao.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MoedaResponseDTO {
    private Long id;
    private String nome;
    private String codigoMoeda;
    private String simboloMoeda;
    private BigDecimal taxa;



}