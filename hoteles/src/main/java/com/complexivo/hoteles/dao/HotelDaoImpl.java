package com.complexivo.hoteles.dao;

import java.util.List;

import com.complexivo.hoteles.model.Hotel;
import com.complexivo.hoteles.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDaoImpl implements HotelDao{

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public List<Hotel> getHotelesDisponibles() {
        // TODO Auto-generated method stub
        List<Hotel> hotelesActivos = hotelRepository.findAllDisponibles();
        return hotelesActivos;
    }
    

}
