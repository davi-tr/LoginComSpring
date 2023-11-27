package com.estudos.br.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroTrat {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity tratarErro400(DataIntegrityViolationException ex){
        var erros = ex.getRootCause();
        if(erros.toString().contains("ACRONIMO")){

            return ResponseEntity.badRequest().body(new MensagemSQL("Acronimo já existe no sistema"));
        }


        return ResponseEntity.badRequest().body(new DadosSQL(erros));
    }

    private record DadosSQL(String mensagem){
        public DadosSQL(Throwable err){
            this(err.getMessage());
        }
    }

    private record MensagemSQL(String mensagem){

    }
    private record MensagemErro(String mensagem){

    }

}
