package com.example.tuningcostaesteapp;

import java.util.Objects;

public class Servicio {

    private int id;
    private String nombre;
    private int fotoURL;

    public Servicio(int id, String nombre, int fotoURL) {
        this.id = id;
        this.nombre = nombre;
        this.fotoURL = fotoURL;
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

    public int getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(int fotoURL) {
        this.fotoURL = fotoURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicio subCategoria = (Servicio) o;
        return id == subCategoria.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
