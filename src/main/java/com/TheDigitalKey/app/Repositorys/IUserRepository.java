package com.TheDigitalKey.app.Repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheDigitalKey.app.bd.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByCorreo(String correo);


}
