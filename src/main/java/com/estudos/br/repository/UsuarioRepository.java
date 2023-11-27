package com.estudos.br.repository;

import com.estudos.br.domain.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findAllByStatusTrue(Pageable paginacao);
    Usuario getReferenceByIdAndStatusTrue(Long id);
}
