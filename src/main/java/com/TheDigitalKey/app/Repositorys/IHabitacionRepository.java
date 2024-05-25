package com.TheDigitalKey.app.Repositorys;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TheDigitalKey.app.bd.Room;

@Repository
public interface IHabitacionRepository extends JpaRepository<Room, Long> {

    @Query("SELECT h FROM Room h WHERE h.hotel.id = :hotelId")
    List<Room> findByHotelId(@Param("hotelId") Long hotelId);

}
