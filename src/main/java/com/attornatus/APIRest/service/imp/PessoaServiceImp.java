package com.attornatus.APIRest.service.imp;

import com.attornatus.APIRest.dto.exception.NaoEncontradoException;
import com.attornatus.APIRest.model.Pessoa;
import com.attornatus.APIRest.repository.EnderecoRepository;
import com.attornatus.APIRest.repository.PessoaRepository;
import com.attornatus.APIRest.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImp implements PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    private EnderecoRepository enderecoRepository;


    public PessoaServiceImp(PessoaRepository repository, EnderecoRepository enderecoRepository) {
        this.pessoaRepository = repository;
        this.enderecoRepository = enderecoRepository;

    }

    @Override
    @Transactional
    public void criar(Pessoa pessoa) {
        pessoaRepository.save(pessoa);

    }

    @Override
    @Transactional
    public Optional<Pessoa> consultar(Long id, Pessoa pessoa) {
        return pessoaRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @Override
    @Transactional
    public Pessoa atualizar(Long id, Pessoa pessoa) {
        pessoa.setId(id);
        pessoaRepository.findById(id).orElseThrow(NaoEncontradoException::new);
        return pessoaRepository.save(pessoa);
    }


}
