package com.complexivo.hoteles.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHotel;

    private int categoria;
    private boolean disponible;
    private String nombre;
    private double precio;
    public Hotel(Long idHotel, int categoria, boolean disponible, String nombre, double precio) {
        this.idHotel = idHotel;
        this.categoria = categoria;
        this.disponible = disponible;
        this.nombre = nombre;
        this.precio = precio;
    }
    public Hotel(int categoria, boolean disponible, String nombre, double precio) {
        this.categoria = categoria;
        this.disponible = disponible;
        this.nombre = nombre;
        this.precio = precio;
    }
    public Hotel() {
    }

    /**
     * @return Long return the idHotel
     */
    public Long getIdHotel() {
        return idHotel;
    }

    /**
     * @param idHotel the idHotel to set
     */
    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    /**
     * @return int return the categoria
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /**
     * @return int return the disponible
     */
    public boolean getDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return double return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
