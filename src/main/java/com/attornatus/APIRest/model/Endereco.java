package com.attornatus.APIRest.model;


import javax.persistence.*;

@Entity
@Table(name = "Endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    boolean enderecoPrincipal;


    public Endereco() {
    }

    public Endereco(String logradouro, String cep, String numero, String cidade, boolean enderecoPrincipal) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.enderecoPrincipal = enderecoPrincipal;
    }


    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean isEnderecoPrincipal() {
        return enderecoPrincipal = false;
    }

    public void setEnderecoPrincipal(boolean enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }


}
