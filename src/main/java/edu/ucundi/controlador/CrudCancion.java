/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucundi.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pojo.Cancion;
import pojo.Album;
import pojo.Artista;

/**
 *
 * @author Eduard Fierro
 */
@ManagedBean(name = "crudCancion")
@RequestScoped
public class CrudCancion implements Serializable {

    private String nombre, duracion, album;
    private double precio;
    private List<Cancion> listaCanciones;
    private List<Album> listaAlbum;
    private List<String> nombreAlbum;

    /**
     * Creates a new instance of CrudCancion
     */
    public CrudCancion() {
    }

    @PostConstruct
    public void init() {
        
       // Cancion c = new Cancion(rtista);
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getExternalContext().getSessionMap().get("listaCanciones") == null) {
            listaCanciones = new ArrayList<>();
        }else{
            listaCanciones = (List<Cancion>) context.getExternalContext().getSessionMap().get("listaCanciones");
        }
        if(context.getExternalContext().getSessionMap().get("listaAlbum") == null){
            listaAlbum = new ArrayList<>();
        }else{
            listaAlbum = (List<Album>) context.getExternalContext().getSessionMap().get("listaAlbum");
            nombreAlbum = new ArrayList<>();
            for(Album d : listaAlbum){
                nombreAlbum.add(d.getNombre());
            }
        }
    }

    public void agregarCancion() {
        Cancion can = new Cancion(nombre, duracion, precio, album);
        listaCanciones.add(can);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaCanciones", this.getListaCanciones());
        nombre="";
        duracion="";
        precio=0;
        album="";
    }

    public void eliminarCancion(Cancion can) {
        listaCanciones.remove(can);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaCanciones", this.getListaCanciones());
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

    public List<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    public List<Album> getListaAlbum() {
        return listaAlbum;
    }

    public void setListaAlbum(List<Album> listaAlbum) {
        this.listaAlbum = listaAlbum;
    }

    public List<String> getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(List<String> nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

}
