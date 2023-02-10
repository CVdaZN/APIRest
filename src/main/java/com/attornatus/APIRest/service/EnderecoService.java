package com.attornatus.APIRest.service;

import com.attornatus.APIRest.model.Endereco;

import javax.transaction.Transactional;
import java.util.List;

public interface EnderecoService {

    Endereco criar(Endereco endereco);

    List<Endereco> buscar();
}
