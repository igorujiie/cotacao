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
    private BigDecimal taxaCompra;
    private BigDecimal taxaVenda;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoMoeda() {
        return codigoMoeda;
    }

    public void setCodigoMoeda(String codigoMoeda) {
        this.codigoMoeda = codigoMoeda;
    }

    public String getSimboloMoeda() {
        return simboloMoeda;
    }

    public void setSimboloMoeda(String simboloMoeda) {
        this.simboloMoeda = simboloMoeda;
    }


    public BigDecimal getTaxaCompra() {
        return taxaCompra;
    }

    public void setTaxaCompra(BigDecimal taxaCompra) {
        this.taxaCompra = taxaCompra;
    }

    public BigDecimal getTaxaVenda() {
        return taxaVenda;
    }

    public void setTaxaVenda(BigDecimal taxaVenda) {
        this.taxaVenda = taxaVenda;
    }
}