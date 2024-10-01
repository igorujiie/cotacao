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

    @Column(name = "valor_taxa_compra",precision = 10,scale = 4, nullable = false)
    private BigDecimal valorTaxaCompra;

    @Column(name = "valor_taxa_venda", precision = 10, scale = 4, nullable = false)
    private BigDecimal valorTaxaVenda;


    @OneToOne
    @JoinColumn(name = "moeda_id", referencedColumnName = "id")
    @JsonBackReference
    private Moeda moeda;

}