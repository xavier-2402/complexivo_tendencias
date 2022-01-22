package com.complexivo.hoteles.repository;

import java.util.List;

import com.complexivo.hoteles.model.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelRepository extends JpaRepository<Hotel,Long>{
    
    @Query("Select h from Hotel h where disponible=True")
    List<Hotel> findAllDisponibles();

    List<Hotel> findByDisponible(Boolean estado);
}
