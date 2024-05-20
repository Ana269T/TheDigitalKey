package com.TheDigitalKey.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheDigitalKey.app.Repositorys.IHotel;
import com.TheDigitalKey.app.bd.Hotel;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private IHotel hotelRepository;

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }
}
