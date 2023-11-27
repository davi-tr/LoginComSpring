package com.estudos.br.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizarSenha(
        @NotBlank
        String senha
) {
}
