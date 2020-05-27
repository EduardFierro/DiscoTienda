/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucundi.controlador;


import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;
import pojo.Admin;


/**
 *
 * @author Eduard Fierro
 */
@ManagedBean(name = "inicio")
@RequestScoped
public class inicio implements Serializable{

    private String nombre;

    /**
     * Creates a new instance of inicio
     */
    public inicio() {
    }
    
    @PostConstruct
    public void creaAdmin(){
        Admin admin = new Admin("admin", "1234");
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("admin", admin);
    }
    public String iniciaSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("usuario", nombre);
        return "vistaCompra.xhtml";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
