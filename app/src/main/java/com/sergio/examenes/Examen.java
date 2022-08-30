package com.sergio.examenes;

import java.util.Date;

public class Examen {
    private Integer id;
    private String materia;
    private String fecha;

    public Examen(int id, String materia, String fecha){
        this.materia = materia;
        this.fecha = fecha;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
