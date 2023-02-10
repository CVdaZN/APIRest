package com.attornatus.APIRest.service.imp;

import com.attornatus.APIRest.model.Endereco;
import com.attornatus.APIRest.repository.EnderecoRepository;
import com.attornatus.APIRest.service.EnderecoService;
import com.attornatus.APIRest.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EnderecoServiceImp implements EnderecoService {


    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;


    @Autowired
    public EnderecoServiceImp(EnderecoRepository repository, EnderecoRepository enderecoRepository, PessoaService pessoaService) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaService = pessoaService;
    }

    @Override
    @Transactional
    public Endereco criar(Endereco endereco) {
        endereco = enderecoRepository.save(endereco);
        return endereco;
    }

    @Override
    @Transactional
    public List<Endereco> buscar() {
        List<Endereco> endereco = enderecoRepository.findAll();
        return endereco;
    }

}
