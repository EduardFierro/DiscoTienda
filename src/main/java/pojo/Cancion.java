/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author AndresChila
 */
public class Cancion {
    private String nombre;
    private String duracion;
    private double precio;
    private String disco;

    public Cancion(String nombre, String duracion, double precio, String disco) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
        this.disco = disco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }
    
}
