package com.estudos.br.domain.usuario;

public record DadosUnicoUsuario(String mensagem, Long id, String nome, String login) {

    public DadosUnicoUsuario (Usuario usuario, String mensagem){
        this(mensagem,usuario.getId(), usuario.getNome(), usuario.getLogin());

    }
}
