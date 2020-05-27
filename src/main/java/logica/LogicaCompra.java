/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import pojo.Artista;
import pojo.Cancion;
import pojo.Album;

/**
 *
 * @author Eduard Fierro
 */
public class LogicaCompra {

    //private String usuario;
    private List<Cancion> listaCanciones;
    private List<Album> listaAlbum;
    private List<Artista> listaArtistas;
    private List<Cancion> compra;
    private double total = 0;

    public LogicaCompra(List<Cancion> listaCanciones, List<Album> listaAlbum, List<Artista> listaArtistas, List<Cancion> compra) {
        this.listaCanciones = listaCanciones;
        this.listaAlbum = listaAlbum;
        this.listaArtistas = listaArtistas;
        this.compra = compra;
    }

    public LogicaCompra() {

    }
  
    public void compraPorArtista(Artista art) {
        for (Artista a : listaArtistas) {
            if (a.getNombre().equals(art.getNombre())) {
                for (Album d : listaAlbum) {
                    if (d.getArtista().equals(art.getNombre())) {
                        for (Cancion c : listaCanciones) {
                            if (c.getAlbum().equals(d.getNombre())) {
                                compra.add(c);
                            }
                        }
                    }
                }
            }
        }
    }

    public void compraPorAlbum(Album al) {
       
        for (Album d : listaAlbum) {
            if (d.getNombre().equals(al.getNombre())) {
                for (Cancion c : listaCanciones) {

                    if (c.getAlbum().equals(al.getNombre())) {
                        if(!compra.contains(c)){
                             compra.add(c);
                        }
                       
                    }
                }
            }
        }
    }

    public void comprarPorCancion(Cancion can) {
       
        for (Cancion c : listaCanciones) {

            if (c.getNombre().equals(can.getNombre())) {
                if(!compra.contains(can)){
                    compra.add(c);
                }
                
            }
        }
    }

    public void finalizarCompra(List<Cancion> compra) {
        for (Cancion c : compra) {
            total += c.getPrecio();
        }
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
