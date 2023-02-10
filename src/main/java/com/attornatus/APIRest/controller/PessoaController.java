package com.attornatus.APIRest.controller;

import com.attornatus.APIRest.dto.EnderecoDTO;
import com.attornatus.APIRest.dto.PessoaDTO;
import com.attornatus.APIRest.model.Pessoa;
import com.attornatus.APIRest.service.EnderecoService;
import com.attornatus.APIRest.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/pessoa")
@Api(value = "API Gerenciamento de Pessoas")
@CrossOrigin(origins = "*")
@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    public PessoaController(PessoaService service, EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
        this.pessoaService = pessoaService;
    }


    @PostMapping()
    @ApiOperation(value = "Cadastrar", response = Pessoa[].class)
    public ResponseEntity<Pessoa> criarPessoas(@RequestBody @Valid PessoaDTO pessoaDTO) {
        pessoaService.criar(pessoaDTO.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    @ApiOperation(value = "Busca", response = Pessoa[].class)
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = pessoaService.listar();
        List<Pessoa> pessoaDTOS = new ArrayList<>(pessoas);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaDTOS);
    }
/*

    @GetMapping
    @ApiOperation(value = "Busca pessoa", response = Pessoa[].class)
    public ResponseEntity<List<Pessoa>> listaEndereco() {
        List<Endereco> enderecospessoas = service.listaEndereco();
        List<Endereco> pt = new ArrayList<>(enderecospessoas);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
*/

    @PutMapping("/{id}")
    @ApiOperation(value = "Alterar", response = Pessoa[].class)
    public ResponseEntity<PessoaDTO> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        pessoaService.atualizar(id, pessoaDTO.toModel());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaDTO);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Consulter", response = Pessoa[].class)
    public ResponseEntity<PessoaDTO> consultarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        pessoaService.consultar(id, pessoaDTO.toModel());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaDTO);
    }


}
