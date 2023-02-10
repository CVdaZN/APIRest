/**/
package com.attornatus.APIRest.dto;

import com.attornatus.APIRest.model.Endereco;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;

public record EnderecoDTO(@NonNull @NotBlank String cep, @NonNull @NotBlank String cidade,
                          @NonNull @NotBlank String logradouro, @NonNull @NotBlank String numero, Boolean enderecoPrincipal) {
    public EnderecoDTO(Endereco endereco) {
        this(endereco.getCidade(), endereco.getLogradouro(), endereco.getNumero(), endereco.getCep(), endereco.isEnderecoPrincipal());
    }


    public Endereco toModel() {
        return new Endereco(toModel().getCep(), toModel().getLogradouro(), toModel().getCidade(), toModel().getNumero(), toModel().isEnderecoPrincipal());
    }
}
