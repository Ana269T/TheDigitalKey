package com.TheDigitalKey.app.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheDigitalKey.app.bd.Habitacion;

@Repository
public interface IHabitacionRepository extends JpaRepository<Habitacion, Long> {

}
