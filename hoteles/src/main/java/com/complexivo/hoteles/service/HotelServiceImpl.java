package com.complexivo.hoteles.service;

import java.util.List;

import com.complexivo.hoteles.dao.HotelDao;
import com.complexivo.hoteles.model.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelDao dao;

    @Override
    public List<Hotel> listarHotelesDisponibles() {
        // TODO Auto-generated method stub
        return dao.getHotelesDisponibles();
    }


    
}
