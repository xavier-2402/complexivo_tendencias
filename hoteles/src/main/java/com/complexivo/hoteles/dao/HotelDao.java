package com.complexivo.hoteles.dao;

import java.util.List;

import com.complexivo.hoteles.model.Hotel;

public interface HotelDao {

    List<Hotel> getHotelesDisponibles();
    
    
}
