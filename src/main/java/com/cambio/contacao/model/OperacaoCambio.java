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

    @ManyToOne
    @JoinColumn(name = "moeda_origem_id", nullable = false)
    private Moeda moedaOrigem;

    @ManyToOne
    @JoinColumn(name = "moeda_destino_id", nullable = false)
    private Moeda moedaDestino;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "valor_convertido", nullable = false)
    private BigDecimal valorConvertido;

    @Column(name = "operacao", nullable = false)
    private Operacao operacao;

    public void calcularValorConvertido() {
        BigDecimal taxaOrigem = moedaOrigem.getTaxa().getValorTaxa();
        BigDecimal taxaDestino = moedaDestino.getTaxa().getValorTaxa();
        this.valorConvertido = this.valor.multiply(taxaOrigem).divide(taxaDestino, 2, BigDecimal.ROUND_HALF_UP);
    }

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
}