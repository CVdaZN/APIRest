package com.attornatus.APIRest.controller;

import com.attornatus.APIRest.model.Endereco;
import com.attornatus.APIRest.service.EnderecoService;
import com.attornatus.APIRest.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/endereco")
@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private PessoaService pessoaService;


    @Autowired
    public EnderecoController(EnderecoService service, EnderecoService enderecoService, PessoaService pessoaService) {
        this.enderecoService = enderecoService;
        this.pessoaService = pessoaService;
    }

    @GetMapping
    @ApiOperation(value = "Lista todos Endereços ", response = Endereco[].class)
    public ResponseEntity buscar() {
        List<Endereco> enderecos = enderecoService.buscar();
        List<Endereco> endereco = enderecos;
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }

    @PostMapping
    @ApiOperation(value = "Insere um novo Endereco", response = Endereco[].class)
    public ResponseEntity<Endereco> criar(@RequestBody Endereco endereco) {
        enderecoService.criar(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }


}
