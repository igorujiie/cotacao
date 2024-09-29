package com.cambio.contacao.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "moeda")
public class Moeda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "codigo_moeda", nullable = false)
    private String codigo;

    @Column(name = "simbolo_moeda", nullable = false)
    private String simbolo;
}