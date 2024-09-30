package com.cambio.contacao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "moeda")
public class Moeda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "codigo_moeda", nullable = false)
    private String codigoMoeda;

    @Column(name = "simbolo_moeda", nullable = false)
    private String simboloMoeda;

    @OneToOne(mappedBy = "moeda", cascade = CascadeType.ALL)
    private Taxa taxa;

    public Moeda() {

    }
}

