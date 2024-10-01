package com.cambio.contacao.util;

import java.math.BigDecimal;

public class Conversor {

    public static BigDecimal converterMoeda(BigDecimal valor, BigDecimal taxa) {
        return valor.multiply(taxa);
    }

}
