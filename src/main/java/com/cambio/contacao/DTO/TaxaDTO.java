package com.cambio.contacao.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TaxaDTO {
    private BigDecimal valorTaxaCompra;
    private BigDecimal valorTaxaVenda;
    private String codigoMoeda;

    public BigDecimal getValorTaxaCompra() {
        return valorTaxaCompra;
    }

    public void setValorTaxaCompra(BigDecimal valorTaxaCompra) {
        this.valorTaxaCompra = valorTaxaCompra;
    }

    public BigDecimal getValorTaxaVenda() {
        return valorTaxaVenda;
    }

    public void setValorTaxaVenda(BigDecimal valorTaxaVenda) {
        this.valorTaxaVenda = valorTaxaVenda;
    }

    public String getCodigoMoeda() {
        return codigoMoeda;
    }

    public void setCodigoMoeda(String codigoMoeda) {
        this.codigoMoeda = codigoMoeda;
    }
}