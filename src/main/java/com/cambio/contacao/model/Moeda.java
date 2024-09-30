package com.cambio.contacao.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    public Moeda(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoMoeda() {
        return codigoMoeda;
    }

    public void setCodigoMoeda(String codigoMoeda) {
        this.codigoMoeda = codigoMoeda;
    }

    public String getSimboloMoeda() {
        return simboloMoeda;
    }

    public void setSimboloMoeda(String simboloMoeda) {
        this.simboloMoeda = simboloMoeda;
    }

    public Taxa getTaxa() {
        return taxa;
    }

    public void setTaxa(Taxa taxa) {
        this.taxa = taxa;
    }
}