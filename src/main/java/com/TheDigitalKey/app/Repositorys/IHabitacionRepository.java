package com.TheDigitalKey.app.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheDigitalKey.app.bd.Room;

@Repository
public interface IHabitacionRepository extends JpaRepository<Room, Long> {

}
