package com.cambio.contacao.model;

import com.cambio.contacao.enums.Operacao;
import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;


@Entity
@Table(name = "operacao_cambio")
public class OperacaoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "moeda_origem_codigo", nullable = false)
    private Moeda moedaOrigem;

    @ManyToOne
    @JoinColumn(name = "moeda_destino_codigo", nullable = false)
    private Moeda moedaDestino;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "valor_convertido", nullable = false)
    private BigDecimal valorConvertido;

    @Column(name = "operacao", nullable = false)
    private Operacao operacao;


    public Moeda getMoedaOrigem() {
        return moedaOrigem;
    }

    public void setMoedaOrigem(Moeda moedaOrigem) {
        this.moedaOrigem = moedaOrigem;
    }

    public Moeda getMoedaDestino() {
        return moedaDestino;
    }

    public void setMoedaDestino(Moeda moedaDestino) {
        this.moedaDestino = moedaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(BigDecimal valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }
}