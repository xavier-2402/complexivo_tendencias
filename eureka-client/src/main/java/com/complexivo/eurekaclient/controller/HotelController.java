package com.complexivo.eurekaclient.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.complexivo.eurekaclient.model.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

@RestController
public class HotelController {

    @Autowired
    RestTemplate restTemplate;

    String url = "http://servicio-hoteles";

    @GetMapping(value="/hoteles",produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Hotel> getHoteles(){

        Hotel[] arrayHoteles = restTemplate.getForObject(url,Hotel[].class);
        return Arrays.asList(arrayHoteles);

    }

    /*
    String urlpython = "http://localhost:8080";

    @GetMapping(value="/hoteles",produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Hotel> getHotelesPython(){

        Hotel[] arrayHoteles = restTemplate.getForObject(urlpython,Hotel[].class);
        return Arrays.asList(arrayHoteles);

    }*/


    

    
}
