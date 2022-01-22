package com.complexivo.hoteles.controller;

import java.util.List;

import com.complexivo.hoteles.model.Hotel;
import com.complexivo.hoteles.service.HotelService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class HotelController {
    
    @Autowired
    HotelService hotelService;

    @GetMapping(value = "/hoteles")
    public List<Hotel> getHotelesDisponibles(){
        return hotelService.listarHotelesDisponibles();
        
    }

    @GetMapping(value = "/hoteles2")
    public String getMensaje(){
        return "Funcionaaaa";
        
    }
}
