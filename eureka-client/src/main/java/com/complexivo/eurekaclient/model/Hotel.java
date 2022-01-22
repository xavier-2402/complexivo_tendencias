package com.complexivo.eurekaclient.model;

public class Hotel {

    public Long idHotel;
    public int Categoria;
    public int disponible;
    public String nombre;
    public double precio;

    public Hotel(Long idHotel, int categoria, int disponible, String nombre, double precio) {
        this.idHotel = idHotel;
        Categoria = categoria;
        this.disponible = disponible;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Hotel(int categoria, int disponible, String nombre, double precio) {
        Categoria = categoria;
        this.disponible = disponible;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Hotel() {
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int categoria) {
        Categoria = categoria;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
