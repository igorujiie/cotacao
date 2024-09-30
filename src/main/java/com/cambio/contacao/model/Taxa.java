package com.cambio.contacao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "taxa")
public class Taxa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_taxa_compra", nullable = false)
    private BigDecimal valorTaxaCompra;

    @Column(name = "valor_taxa_venda", nullable = false)
    private BigDecimal valorTaxaVenda;


    @OneToOne
    @JoinColumn(name = "moeda_id", referencedColumnName = "id")
    @JsonBackReference
    private Moeda moeda;

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

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }
}