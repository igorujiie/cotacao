package com.cambio.contacao.model;


import com.cambio.contacao.enums.Operacao;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OperacaoCambio {
    private Moeda moedaOrigem;
    private Moeda moedaDestino;
    private BigDecimal valor;
    private BigDecimal valorConvertido;
    private Operacao operacao;
}
