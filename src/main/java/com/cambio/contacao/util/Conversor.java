package com.cambio.contacao.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Conversor {

    public static BigDecimal converterCompraDeMoeda(BigDecimal valor, BigDecimal taxa) {
        return valor.multiply(taxa);
    }

    public static BigDecimal converterVendaDeMoeda(BigDecimal valor, BigDecimal taxa) {
        return valor.divide(taxa, 2, RoundingMode.HALF_UP);

    }
}
