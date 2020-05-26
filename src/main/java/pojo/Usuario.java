/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.List;

/**
 *
 * @author AndresChila
 */
public class Usuario {
    private String nombre;
    private List<Cancion> carrito;

    public Usuario(String nombre, List<Cancion> carrito) {
        this.nombre = nombre;
        this.carrito = carrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cancion> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Cancion> carrito) {
        this.carrito = carrito;
    }
    
}
