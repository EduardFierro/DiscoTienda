/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Eduard Fierro
 */
public class Artista {
    private String nombre;
    private String apellido;
    private Date fechana;
    private String nacionalidad;
    

    public Artista(String nombre, String apellido, Date fechana, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechana = fechana;
        this.nacionalidad = nacionalidad;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechana() {
        return fechana;
    }

    public void setFechana(Date fechana) {
        this.fechana = fechana;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
