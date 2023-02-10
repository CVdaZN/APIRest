package com.attornatus.APIRest.component;

import com.attornatus.APIRest.model.Endereco;
import com.attornatus.APIRest.model.EnderecoPrincipal;
import org.springframework.stereotype.Component;

@Component
public class EnderecoValidador {

    private void validarEnderecoPrincipal(String endPrincipal) {
    }

    public Endereco validarFormato(Endereco endereco) {
        if (endereco.getEnderecoPrincipal() == EnderecoPrincipal.NAO) {
            validarEnderecoPrincipal("Não");
        }
        validarEnderecoPrincipal("Sim");

        return validarFormato(endereco);
    }

}
