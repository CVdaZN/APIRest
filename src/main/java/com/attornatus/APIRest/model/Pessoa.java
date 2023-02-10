package com.attornatus.APIRest.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dtNascimento;
    @Cascade(value = org.hibernate.annotations.CascadeType.PERSIST)
    @ManyToMany
    private List<Endereco> enderecos;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, LocalDate dtNascimento, List enderecos) {
        this.id = id;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.enderecos = enderecos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }


}


