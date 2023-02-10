package com.attornatus.APIRest.dto;

import com.attornatus.APIRest.model.Endereco;
import com.attornatus.APIRest.model.Pessoa;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;


public record PessoaDTO(
        Long id,
        @NotBlank String nome,
        @NonNull LocalDate dtNascimento,
        @NonNull List<Endereco> enderecos

) {

    public PessoaDTO(Long id, @NotBlank String nome, @NonNull LocalDate dtNascimento,  @NonNull List<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.enderecos = enderecos;
    }

   public Pessoa toModel(){
        return new Pessoa(null, nome(), dtNascimento(), enderecos());
    }
}
