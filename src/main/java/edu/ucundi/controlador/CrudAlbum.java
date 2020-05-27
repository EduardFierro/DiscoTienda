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
import pojo.Artista;
import pojo.Album;

/**
 *
 * @author Eduard Fierro
 */
@ManagedBean(name = "crudAlbum")
@RequestScoped
public class CrudAlbum implements Serializable {
    public String nombre, artista;
    public List<Artista> listaArtista;
    public List<Album> listaAlbum;
    public List<String> nombresArtistas = new ArrayList<>();
    /**
     * Creates a new instance of CrudDisco
     */
    public CrudAlbum() {
    }
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(context.getExternalContext().getSessionMap().get("listaArtista") == null){
            listaArtista = new ArrayList<>();
        }else{
            listaArtista = (List<Artista>) context.getExternalContext().getSessionMap().get("listaArtista");
        }
        if(context.getExternalContext().getSessionMap().get("listaAlbum")==null){
            listaAlbum = new ArrayList<>();
        }
        else{
            listaAlbum = (List<Album>) context.getExternalContext().getSessionMap().get("listaAlbum");
        }
        for(Artista a : listaArtista){
            nombresArtistas.add(a.getNombre());
        }
    }
    public void agregarAlbum(){
        Album al = new Album( nombre, artista);
        listaAlbum.add(al);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaAlbum", this.getListaAlbum());
        
        nombre="";
        artista="";
    }
    public void eliminarAlbum(Album al){
        listaAlbum.remove(al);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaAlbum", this.getListaAlbum());
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

    public List<Album> getListaAlbum() {
        return listaAlbum;
    }

    public void setListaAlbum(List<Album> listaAlbum) {
        this.listaAlbum = listaAlbum;
    }

    public List<String> getNombresArtistas() {
        return nombresArtistas;
    }

    public void setNombresArtistas(List<String> nombresArtistas) {
        this.nombresArtistas = nombresArtistas;
    }
    
}
