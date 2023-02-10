package com.attornatus.APIRest.dto.exception;

public class NaoEncontradoException extends RuntimeException{
    public NaoEncontradoException() {
        super("Pessoa não encontrada");
    }

}
