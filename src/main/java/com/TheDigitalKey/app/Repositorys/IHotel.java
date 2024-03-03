package com.TheDigitalKey.app.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheDigitalKey.app.bd.Hotel;

@Repository
public interface IHotel extends JpaRepository<Hotel, Long>{

}
