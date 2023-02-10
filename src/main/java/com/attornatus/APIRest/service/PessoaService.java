package com.attornatus.APIRest.service;


import com.attornatus.APIRest.model.Endereco;
import com.attornatus.APIRest.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

    void criar(Pessoa pessoa);
    Optional<Pessoa> consultar(Long id, Pessoa pessoa);

    List<Pessoa> listar();


    Pessoa atualizar(Long id, Pessoa pessoa);


}
