package com.cambio.contacao.DTO;

import com.cambio.contacao.enums.Operacao;
import com.cambio.contacao.model.Moeda;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OperacaoDeCambioVendaDTO {
    private Moeda moeda;
    private BigDecimal valor;
    private Operacao operacao;
    private BigDecimal valorConvertido;

}
