package com.example.tuningcostaesteapp;

import java.util.Objects;

public class Diseno {

    private int id;
    private String nombre;
    private int tipoAutomovil;
    private int fotoURL;
    private int tipoServicio;
    private String descripcion;
    private String material;
    private int colores;
    private boolean disponibilidad;

    public Diseno(int id, String nombre, int tipoAutomovil, int fotoURL, int tipoServicio, String descripcion, String material, int colores, boolean disponibilidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipoAutomovil = tipoAutomovil;
        this.fotoURL = fotoURL;
        this.tipoServicio = tipoServicio;
        this.descripcion = descripcion;
        this.material = material;
        this.colores = colores;
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipoAutomovil() {
        return tipoAutomovil;
    }

    public void setTipoAutomovil(int tipoAutomovil) {
        this.tipoAutomovil = tipoAutomovil;
    }

    public int getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(int fotoURL) {
        this.fotoURL = fotoURL;
    }

    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getColores() {
        return colores;
    }

    public void setColores(int colores) {
        this.colores = colores;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diseno diseno = (Diseno) o;
        return id == diseno.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
