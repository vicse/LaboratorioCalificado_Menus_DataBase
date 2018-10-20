package com.ore.vicse.notas.models;

import com.orm.dsl.Table;
@Table
public class Nota {

    private Long id;
    private String tittle;
    private String contenido;

    public Nota() {
    }

    public Nota(String tittle, String contenido) {
        this.tittle = tittle;
        this.contenido = contenido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}
