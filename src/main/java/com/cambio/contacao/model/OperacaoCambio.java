package com.cambio.contacao.model;


import com.cambio.contacao.enums.Operacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "operacao_cambio")
public class OperacaoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "moeda_origem", nullable = false)
    private Moeda moedaOrigem;

    @Column(name = "moeda_destino", nullable = false)
    private Moeda moedaDestino;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "valor_convertido", nullable = false)
    private BigDecimal valorConvertido;

    @Column(name = "operacao", nullable = false)
    private Operacao operacao;
}
