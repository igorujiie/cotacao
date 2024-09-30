package com.cambio.contacao.util;

import java.math.BigDecimal;

public class Conversor {

    public static BigDecimal converterCompraDeMoeda(BigDecimal valor, BigDecimal taxa) {
        return valor.multiply(taxa);
    }

    public static BigDecimal converterVendaDeMoeda(BigDecimal valor, BigDecimal taxa) {
        return valor.divide(taxa);
    }
}
