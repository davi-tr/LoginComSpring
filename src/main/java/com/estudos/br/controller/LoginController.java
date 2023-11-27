package com.estudos.br.controller;


import com.estudos.br.domain.usuario.DadosCadastroUsuario;
import com.estudos.br.domain.usuario.DadosUnicoUsuario;
import com.estudos.br.domain.usuario.Usuario;
import com.estudos.br.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioRepository repository;


    @PostMapping
    public ResponseEntity cadastro (@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder){
        var usuario = new Usuario(dados);
        repository.save(usuario);

        var uri = uriBuilder.path("usr/id={id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosUnicoUsuario(usuario, "Usuario Criado!"));
    }
}
