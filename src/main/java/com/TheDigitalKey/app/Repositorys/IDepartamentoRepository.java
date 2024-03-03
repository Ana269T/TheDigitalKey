package com.TheDigitalKey.app.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheDigitalKey.app.bd.Departamento;

@Repository
public interface IDepartamentoRepository extends JpaRepository<Departamento, Long> {

}
