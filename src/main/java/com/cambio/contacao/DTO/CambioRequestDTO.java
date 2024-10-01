package com.cambio.contacao.DTO;

import com.cambio.contacao.enums.Operacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class CambioRequestDTO {
    @NotBlank(message = "Moeda de origem não pode ser nula ou vazia")
    private String moedaOrigem;

    @NotBlank(message = "Moeda de destino não pode ser nula ou vazia")
    private String moedaDestino;

    @NotNull(message = "Valor deve estar preenchido")
    private BigDecimal valor;

    @NotNull(message = "Operação deve estar preenchida")
    private Operacao operacao;


    public void convertOperacaoToUpperCase() {
        if (this.operacao != null) {
            this.operacao = Operacao.valueOf(this.operacao.name().toUpperCase());
        }
    }
}