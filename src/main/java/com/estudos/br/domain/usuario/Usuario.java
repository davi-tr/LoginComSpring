package com.estudos.br.domain.usuario;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "usuario")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String login;

    private String password;

    private Boolean status;

    public Usuario(DadosCadastroUsuario dados){
        this.status = true;
        this.nome = dados.nome();
        this.password = dados.senha();
        this.login = dados.login();
    }

    public void excluir(){
        this.status = false;
    }

    public void atualizarSenha(DadosAtualizarSenha dados){
        this.password = dados.senha();
    }
}
