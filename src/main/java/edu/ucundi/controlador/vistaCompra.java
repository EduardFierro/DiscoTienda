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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logica.LogicaCompra;
import pojo.Artista;
import pojo.Cancion;
import pojo.Album;

/**
 *
 * @author Eduard Fierro
 */
@ManagedBean(name = "vistaCompra")
@SessionScoped
public class vistaCompra implements Serializable{

    private String usuario;
    private List<Cancion> listaCanciones;
    private List<Album> listaAlbum;
    private List<Artista> listaArtistas;
    private List<String> nombreCanciones, nombreAlbum, nombreArtistas;
    private List<Cancion> compra;
    private double total;

    /**
     * Creates a new instance of vistaCompra
     */
    public vistaCompra() {
    }

    @PostConstruct
    public void init() {
        if(compra == null){
            compra = new ArrayList<>();
        }
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getExternalContext().getSessionMap().get("listaCanciones") == null) {
            listaCanciones = new ArrayList<>();
        } else {
            listaCanciones = (List<Cancion>) context.getExternalContext().getSessionMap().get("listaCanciones");
            nombreCanciones= new ArrayList<>();
            for (Cancion ca : listaCanciones) {
                nombreCanciones.add(ca.getNombre());
            }
        }
        if (context.getExternalContext().getSessionMap().get("listaAlbum") == null) {
            listaAlbum = new ArrayList<>();
        } else {
            listaAlbum = (List<Album>) context.getExternalContext().getSessionMap().get("listaAlbum");
            nombreAlbum = new ArrayList<>();
            for (Album di : listaAlbum) {
                nombreAlbum.add(di.getNombre());
            }
        }
        if (context.getExternalContext().getSessionMap().get("listaArtista") == null) {
            listaArtistas = new ArrayList<>();
        } else {
            listaArtistas = (List<Artista>) context.getExternalContext().getSessionMap().get("listaArtista");
            nombreArtistas = new ArrayList<>();
            for (Artista ar : listaArtistas) {
                nombreArtistas.add(ar.getNombre());
            }
        }
        usuario = (String) context.getExternalContext().getSessionMap().get("usuario");
    }

    public void agregarCarritoPorArtista(Artista artista) {
        LogicaCompra logica = new LogicaCompra(listaCanciones, listaAlbum, listaArtistas, compra);
        logica.compraPorArtista(artista);
        compra = logica.getCompra();
    }

    public void agregarCarritoPorAlbum(Album album) {
        LogicaCompra logica = new LogicaCompra(listaCanciones, listaAlbum, listaArtistas, compra);
        logica.compraPorAlbum(album);
        compra = logica.getCompra();
    }

    public void agregarCarritoPorCancion(Cancion cancion) {
        LogicaCompra logica = new LogicaCompra(listaCanciones, listaAlbum, listaArtistas, compra);
        logica.comprarPorCancion(cancion);
        this.setCompra(logica.getCompra());
    }

    public String finalizarCompra() {
        LogicaCompra logica = new LogicaCompra();
        logica.finalizarCompra(compra);
        total = logica.getTotal();
        return ("recibo.xhtml");
    }
    public String LimpiarLista(){
        compra.clear();
        return("inicio.xhtml");
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public List<Artista> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(List<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }

    public List<String> getNombreCanciones() {
        return nombreCanciones;
    }

    public void setNombreCanciones(List<String> nombreCanciones) {
        this.nombreCanciones = nombreCanciones;
    }

    public List<String> getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(List<String> nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public List<String> getNombreArtistas() {
        return nombreArtistas;
    }

    public void setNombreArtistas(List<String> nombreArtistas) {
        this.nombreArtistas = nombreArtistas;
    }

    public List<Cancion> getCompra() {
        return compra;
    }

    public void setCompra(List<Cancion> compra) {
        this.compra = compra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
