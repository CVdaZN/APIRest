package com.attornatus.APIRest.service;

import com.attornatus.APIRest.dto.exception.NaoEncontradoException;
import com.attornatus.APIRest.model.Pessoa;
import com.attornatus.APIRest.repository.PessoaRepository;
import com.attornatus.APIRest.service.imp.PessoaServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@SpringBootTest
@ContextConfiguration(classes = {PessoaServiceImp.class})
class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    @MockBean
    private PessoaRepository pessoaRepository;


    @Test
    void criarFormatoCerto() {
        Pessoa pessoa = new Pessoa(null, "caio", LocalDate.of(1994, 10, 30), List.of());
        Assertions.assertThatCode(() -> pessoaService.criar(pessoa)).doesNotThrowAnyException();

    }

    @Test
    void criarFormatoErrado() {
        Pessoa pessoa = new Pessoa(null, "caio", LocalDate.of(1994, 10, 30), List.of());
        Assertions.assertThatExceptionOfType(DataFormatException.class).isThrownBy(() -> pessoaService.criar(pessoa)).withMessage("Formato Invalido");
    }
/*
    @Test
    void consultarInexistente() {
        Mockito.when(pessoaRepository.findById(1l)).thenReturn(Optional.empty());
        Assertions.assertThatExceptionOfType(ChangeSetPersister.NotFoundException.class).isThrownBy(() -> pessoaService.consultar( new Pessoa(null, "caio", LocalDate.of(1994, 10, 30), List.of())).withMessage("pessoa não cadastrada");

    }*/


    @Test
    void listarPessoaCorreatmente() {
        Mockito.when(pessoaRepository.findById(1l)).thenReturn(Optional.empty());
        Assertions.assertThatExceptionOfType(ChangeSetPersister.NotFoundException.class).isThrownBy(() -> pessoaService.listar()).withMessage("Pessoas não cadastrada");

    }

    @Test
    void atualizarNaoExistente() {
        Mockito.when(pessoaRepository.existsById(1L)).thenReturn(true);
        Assertions.assertThatExceptionOfType(NaoEncontradoException.class).isThrownBy(() -> pessoaService.atualizar(1L, new Pessoa())).withMessage("Pessoa não Atulizada");

    }

    @Test
    void atualizarPessoasExistente() {
        Pessoa pessoa = new Pessoa(null, "caio", LocalDate.of(1994, 10, 30), List.of());
        Assertions.assertThatCode(() -> pessoaService.atualizar(1L, pessoa));
        Mockito.verify(pessoaRepository).findById(1L);
    }
}