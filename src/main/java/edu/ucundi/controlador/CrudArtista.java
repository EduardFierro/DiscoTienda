/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucundi.controlador;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.LogicaCrudArtista;
import pojo.Artista;

/**
 *
 * @author Eduard Fierro
 */
@ManagedBean(name = "crudArtista")
@RequestScoped
public class CrudArtista implements Serializable {
    private String apellido, nombre;
    private Date fechana;
    private List<Artista> lista;
    /**
     * Creates a new instance of CrudArtista
     */
    public CrudArtista() {
    }
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(context.getExternalContext().getSessionMap().get("listaArtista")== null){
            lista = new ArrayList<>();
        }else{
            lista = (List<Artista>) context.getExternalContext().getSessionMap().get("listaArtista");
        }
        
    }
    public void agregaArtista(){
        Artista art = new Artista(nombre, apellido, fechana);
        lista.add(art);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaArtista", this.getLista());
        nombre="";
        apellido="";
        fechana=null;
    }
    public void eliminarArtista(Artista art){
        LogicaCrudArtista logica = new LogicaCrudArtista(lista, art);
        logica.eliminarArtista();
        this.setLista(logica.getLista());
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaArtista", this.getLista());
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechana() {
        return fechana;
    }

    public void setFechana(Date fechana) {
        this.fechana = fechana;
    }

    public List<Artista> getLista() {
        return lista;
    }

    public void setLista(List<Artista> lista) {
        this.lista = lista;
    }
    
}
