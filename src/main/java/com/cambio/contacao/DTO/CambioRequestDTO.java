package com.cambio.contacao.DTO;

import com.cambio.contacao.enums.Operacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CambioRequestDTO {
    @NotBlank(message = "Moeda de origem não pode ser nula ou vazia")
    private String moedaOrigem;

    @NotBlank(message = "Moeda de destino não pode ser nula ou vazia")
    private String moedaDestino;

    @NotNull(message = "Valor deve estar preenchido")
    private BigDecimal valor;

    @NotNull(message = "Operação deve estar preenchida")
    private Operacao operacao;

    public String getMoedaOrigem() {
        return moedaOrigem;
    }

    public void setMoedaOrigem(String moedaOrigem) {
        this.moedaOrigem = moedaOrigem;
    }

    public String getMoedaDestino() {
        return moedaDestino;
    }

    public void setMoedaDestino(String moedaDestino) {
        this.moedaDestino = moedaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public void convertOperacaoToUpperCase() {
        if (this.operacao != null) {
            this.operacao = Operacao.valueOf(this.operacao.name().toUpperCase());
        }
    }
}