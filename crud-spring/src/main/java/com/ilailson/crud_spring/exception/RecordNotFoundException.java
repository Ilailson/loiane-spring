package com.ilailson.crud_spring.exception;

public class RecordNotFoundException extends RuntimeException{

    // Excecao generica
    public RecordNotFoundException(Long id) {
        super("Registro não encontrado com id: " + id);
    }

}
