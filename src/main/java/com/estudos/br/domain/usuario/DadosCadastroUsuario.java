package com.estudos.br.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank
        String nome,
        @NotBlank
        String login,
        @NotBlank
        String senha)
{

}
