package com.attornatus.APIRest.service;

import com.attornatus.APIRest.dto.exception.NaoEncontradoException;
import com.attornatus.APIRest.model.Endereco;
import com.attornatus.APIRest.repository.EnderecoRepository;
import com.attornatus.APIRest.service.imp.EnderecoServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;


@SpringBootTest
@ContextConfiguration(classes = {EnderecoServiceImp.class})
class EnderecoServiceTest {

    @Autowired
    private EnderecoService enderecoService;

    @MockBean
    private EnderecoRepository enderecoRepository;

    @Test
    void criarEnderecoCorretamente() {
        Endereco endereco = new Endereco("rua.São Campos", "22010-010", "14", "SP");
        Assertions.assertThatCode(() -> enderecoService.criar(endereco)).doesNotThrowAnyException();
    }

    @Test
    void criarEnderecoErrado() {
        Endereco endereco = new Endereco("", "", "", "");
        Assertions.assertThatExceptionOfType(ChangeSetPersister.NotFoundException.class).isThrownBy(() -> enderecoService.criar(endereco)).withMessage("Formato Invalido");
    }

    @Test
    void buscarEnderecoInexistente() {
        Mockito.when(enderecoRepository.findById(1l)).thenReturn(Optional.empty());
        Assertions.assertThatExceptionOfType(NaoEncontradoException.class)
                .isThrownBy(()-> enderecoService.buscar())
                .withMessage("Endereco não cadastrada");

    }
}