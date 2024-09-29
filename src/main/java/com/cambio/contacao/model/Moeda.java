package com.cambio.contacao.model;

import jakarta.persistence.*;
import lombok.Data;
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
    private String codigo;

    @Column(name = "simbolo_moeda", nullable = false)
    private String simbolo;

    @OneToOne(mappedBy = "moeda", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Taxa taxa;

    public Taxa getTaxa() {
        return taxa;
    }

    public void setTaxa(Taxa taxa) {
        this.taxa = taxa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}