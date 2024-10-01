package com.cambio.contacao.DTO;

import com.cambio.contacao.enums.Operacao;
import com.cambio.contacao.model.Moeda;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class CambioResponseDTO {

    private String codigoMoeda;
    private BigDecimal valor;
    private BigDecimal valorConvertido;
    private Operacao operacao;


}
